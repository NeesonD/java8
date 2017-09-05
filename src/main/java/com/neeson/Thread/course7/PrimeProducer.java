package com.neeson.Thread.course7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * Create by neeson on 2017/9/5
 */
public class PrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run(){
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted())
                queue.put(p = p.nextProbablePrime());
        }catch (InterruptedException e){

        }
    }

    public void cancel(){
        interrupt();
    }
}
