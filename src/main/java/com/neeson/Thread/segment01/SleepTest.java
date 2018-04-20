package com.neeson.Thread.segment01;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/3/19
 * Time: 11:00
 * Description:
 */
public class SleepTest {



    public static void main(String[] args) throws InterruptedException {
        Mythread1 thread = new Mythread1();
        Thread thread1 = new Thread(thread);
        thread1.start();
        Thread.sleep(3000);
        System.out.println("===>"+Thread.currentThread().getName());
    }

    static class Mythread1 implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">>>"+Thread.currentThread().getName());
        }

    }

}
