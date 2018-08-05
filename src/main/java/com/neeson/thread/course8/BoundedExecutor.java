package com.neeson.thread.course8;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * Created by daile on 2017/9/8.
 */
public class BoundedExecutor {

    private final Executor exec;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec,int bound){
        this.exec = exec;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(() ->{
                try {
                    command.run();
                }finally {
                    semaphore.release();
                }
            });
        }catch (RejectedExecutionException e){
            semaphore.release();
        }
    }

}
