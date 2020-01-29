package com.neeson.thread.semaphore;

import java.util.concurrent.Semaphore;

public class MyLock {

    private static Semaphore semaphore = new Semaphore(1);

    void lock() throws InterruptedException {
        semaphore.acquire();
    }

    void unlock() {
        semaphore.release();
    }

    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(()->{
            try {
                lock.lock();
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            try {
                System.out.println("等待");
                lock.lock();
                System.out.println("获得锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }

}
