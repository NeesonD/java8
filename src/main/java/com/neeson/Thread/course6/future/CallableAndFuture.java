package com.neeson.Thread.course6.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by daile on 2017/9/1.
 */
public class CallableAndFuture {

    public static final int NUMBER = 20;
    private static final Executor executor = Executors.newFixedThreadPool(NUMBER);

    public static void main(String[] args) throws InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        };
        FutureTask<Integer> ft = new FutureTask<Integer>(callable);
        executor.execute(ft);
        try {
            Thread.sleep(5000);
            System.out.println(ft.get());
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }

}
