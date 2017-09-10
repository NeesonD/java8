package com.neeson.Thread.course9;

import com.neeson.domain.Account;
import com.neeson.domain.DollarAmount;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Create by neeson on 2017/9/10
 */
public class DemonstrateDeadLock {

    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS= 1000000;

    public static void main(String[] args) {
        final Random rnd = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNTS];
        for (int i = 0;i<accounts.length;i++){
            accounts[i] = new Account();
        }
        class TransferThread extends Thread{
            public void run(){
                for (int i =0;i<NUM_ITERATIONS;i++){
                    int fromAccount = rnd.nextInt(NUM_ACCOUNTS);
                    int toAccount = rnd.nextInt(NUM_ACCOUNTS);
                    DollarAmount amount = new DollarAmount(rnd.nextInt(1000));

                }
            }
        }
        for (int i=0;i<NUM_THREADS;i++){
            new TransferThread().start();
        }
    }

}
