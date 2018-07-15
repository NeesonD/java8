package com.neeson.thread.segment01;

import com.neeson.thread.segment01.MyThread;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: neeson
 * Date: 2018/3/17
 * Time: 10:37
 * Description:
 */
public class MyThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println( Thread.currentThread().getName());
      //  new MyThreadTest().test1();
      //  new MyThreadTest().test2();
        //new MyThreadTest().test3();
    }


    public void test1() {
        System.out.println("主线程ID:" + Thread.currentThread().getId());
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        MyThread thread2 = new MyThread("thread2");
        thread2.start();
    }


    public void test2() {
        System.out.println("主线程Id：" + Thread.currentThread().getId());
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

    public void test3() throws ExecutionException, InterruptedException {
        System.out.println("程序开始");
        Date date = new Date();
        int taskSize = 200;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i <taskSize ; i++) {
            Callable c = new MyCallable(i+ " ");
            Future f = pool.submit(c);
            futures.add(f);
        }

        pool.shutdown();

        for (Future future : futures) {
            System.out.println(">>>"+future.get().toString());
        }

        Date date1 = new Date();
        System.out.println("程序运行时间："+(date1.getTime() - date.getTime()));
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("子线程ID：" + Thread.currentThread().getId());
        }
    }


    class MyCallable implements Callable {

        private String taskNum;

        public MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(">>>" + taskNum + "任务启动");
            Date date = new Date();
            Thread.sleep(1000);
            Date temp2 = new Date();
            long time = temp2.getTime() - date.getTime();
            System.out.println(">>>"+taskNum+"任务终止");
            return taskNum + "任务返回运行结果，运行时间："+time;
        }
    }

}
