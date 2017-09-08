package com.neeson.Thread.course7;

import javafx.concurrent.Task;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * Create by neeson on 2017/9/5
 */
public class BrokenPrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;

    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {

        }
    }

    public void cancell() {
        cancelled = true;
    }

    void comsumePrimes() throws InterruptedException {
        BlockingQueue<BigInteger> primes = new ArrayBlockingQueue<BigInteger>(1);

        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();
        try {
            while (true) {
                consume(primes.take());
            }
        } finally {
            producer.cancell();
        }
    }

    private void consume(BigInteger take) {
    }

    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrypted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrypted = true;
                }
            }
        } finally {
            if (interrypted)
                Thread.currentThread().interrupt();
        }
    }
}
