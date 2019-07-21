package com.neeson.thread.geek;

import javafx.concurrent.Task;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author : neeson
 * Date: 2019/7/19
 * Time: 20:55
 * Description: 批处理
 */
public class ProduceAndConsumer {

	BlockingQueue<Task> bq = new LinkedBlockingQueue<>(200);

	void start() {
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i <5 ; i++) {
			es.execute(()->{
				while (true) {
					List<Task> ts = null;
					try {
						ts = pollTasks();
					} catch (InterruptedException e) {

					}
					execTasks(ts);
				}
			});
		}
	}

	private void execTasks(List<Task> ts) {

	}

	private List<Task> pollTasks() throws InterruptedException {
		List<Task> ts = new LinkedList<>();
		Task t = bq.take();
		while (Objects.nonNull(t)) {
			ts.add(t);
			t = bq.poll();
		}
		return ts;
	}


}
