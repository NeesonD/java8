package com.neeson.thread.segment01;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/13
 * Time: 10:35
 * Description:
 */
public class Executor {

    private static ExecutorService service = Executors.newFixedThreadPool(20);
    private static AtomicInteger a= new AtomicInteger();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*Future<?> submit = service.submit(new Run());
        //Thread.sleep(1000);
        //System.out.println(submit.cancel(false));
        try {
            System.out.println(submit.get(1, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("======>超市");
        }*/
        test1();
    }

    static void test1() throws ExecutionException, InterruptedException {
        //service.execute(()->{});
        Future submit = service.submit(new Call());
        System.out.println(submit.isDone());
        System.out.println(submit.get());
        System.out.println(submit.isDone());
        Future<?> submit1 = service.submit(new Run());
        System.out.println(submit1.get());

    }

    static class Run implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(a.getAndIncrement());
        }
    }

    static class Call implements Callable{

        @Override
        public Object call() throws Exception {
            Thread.sleep(1000);
            return "66";
        }
    }

}
