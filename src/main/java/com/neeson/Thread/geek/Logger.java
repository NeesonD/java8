package com.neeson.thread.geek;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author : neeson
 * Date: 2019/7/19
 * Time: 21:05
 * Description: 
 */
public class Logger<T> {

	final BlockingQueue<T> bq = new LinkedBlockingQueue<>(200);

	static final int batchSize = 500;

	ExecutorService es = Executors.newFixedThreadPool(1);

	void start() throws IOException {
		File file = File.createTempFile("foo", ".log");
		FileWriter writer = new FileWriter(file);
		es.execute(()->{
			int curIdx = 0;
			long preFT = System.currentTimeMillis();
			while (true) {
				T log = null;
				try {
					log = bq.poll(5, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (Objects.nonNull(log)) {
					try {
						writer.write(log.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
					++curIdx;
				}
				if (curIdx <= 0) {
					continue;
				}
				if (Objects.nonNull(log) && log.equals("ERROR") || curIdx == batchSize
						|| System.currentTimeMillis() - preFT > 5000) {
					try {
						writer.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
					curIdx = 0;
					preFT = System.currentTimeMillis();
				}
			}
		});
	}

	void info(T msg) throws InterruptedException {
		bq.put(msg);
	}

}
