package com.neeson.Thread.course12;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by daile on 2017/9/12.
 */
public class TestSemaphore {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            final int NO = i;
            Runnable runnable = () -> {
                try {
                    semp.acquire();
                    System.out.println("Accessing:" + NO);
                    Thread.sleep((long) (Math.random() * 10000));
                    semp.release();
                    System.out.println("------" + semp.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();
    }

}
