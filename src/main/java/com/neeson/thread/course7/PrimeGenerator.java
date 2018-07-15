package com.neeson.thread.course7;

import javax.annotation.concurrent.ThreadSafe;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.lang.Thread.*;

@ThreadSafe
public class PrimeGenerator implements Runnable {

    private final List<BigInteger> prims = new ArrayList<>();

    private volatile boolean cancelled;
    //通过cancelled来请求取消
    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled){
            p = p.nextProbablePrime();
            synchronized (this){
                prims.add(p);
            }
        }
    }

    public void cancel(){
        cancelled = true;
    }

    public synchronized List<BigInteger> get(){
        return new ArrayList<>(prims);
    }

    List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        PrimeGenerator generator = new PrimeGenerator();
        executor.execute(generator);
        try {
            sleep(1);
        }finally {
            generator.cancel();
        }
        return generator.get();
    }
}
