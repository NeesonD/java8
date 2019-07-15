package com.neeson.thread.test;

/**
 * @author : neeson
 * Date: 2019/6/11
 * Time: 20:21
 * Description: 
 */
public class NotifyTest {

	private Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		NotifyTest notifyTest = new NotifyTest();
		new Thread(()->{
			try {
				notifyTest.test(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				notifyTest.test(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}


	public void test(int a) throws InterruptedException {
		synchronized (lock) {
			if (a == 1) {
				lock.wait();
			}
			lock.notify();
			if (a == 2) {
				Thread.sleep(2000);
			}
			System.out.println("===" + a);
		}
	}

}
