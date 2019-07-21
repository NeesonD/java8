package com.neeson.thread.geek;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : neeson
 * Date: 2019/7/19
 * Time: 20:31
 * Description: 
 */
public class DeadLockThreadPool {

	ExecutorService es = Executors.newFixedThreadPool(2);
	CountDownLatch l1 = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {
		new DeadLockThreadPool().run();
	}

	void run() throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			System.out.println("l1");
			es.execute(() -> {
				CountDownLatch l2 = new CountDownLatch(2);
				for (int j = 0; j < 2; j++) {
					es.execute(() -> {
						System.out.println("l2");
						l2.countDown();
					});
				}
				System.out.println("---");
				try {
					l2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				l1.countDown();
			});
		}
		l1.await();
		System.out.println("end");
	}

}
