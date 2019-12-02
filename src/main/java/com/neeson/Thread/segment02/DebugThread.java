package com.neeson.thread.segment02;

import java.util.concurrent.*;

/**
 * @author : neeson
 * Date: 2019/12/2
 * Time: 23:04
 * Description: 
 */
public class DebugThread {

	static ExecutorService es = new ThreadPoolExecutor(2, 2, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r,"neeson");
		}
	});

	public static void main(String[] args) {
		es.submit(() -> System.out.println(Thread.currentThread().getName()));
		es.submit(() -> System.out.println(Thread.currentThread().getName()));
		es.submit(() -> System.out.println(Thread.currentThread().getName()));
	}

}
