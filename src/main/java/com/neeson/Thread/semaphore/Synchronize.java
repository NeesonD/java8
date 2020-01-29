package com.neeson.thread.semaphore;

import java.util.concurrent.Semaphore;

public class Synchronize {

    private static Semaphore semaphore = new Semaphore(0);

    void await() throws InterruptedException {
        semaphore.acquire();
    }

    void signal() {
        semaphore.release();
    }

    public static void main(String[] args) throws InterruptedException {
        Synchronize synchronize = new Synchronize();
        new Thread(()->{
            try {
                System.out.println("阻塞");
                synchronize.await();
                System.out.println("同步");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000L);
        new Thread(()->{
            System.out.println("释放");
            synchronize.signal();
        }).start();
    }

}
