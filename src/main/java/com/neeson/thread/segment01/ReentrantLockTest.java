package com.neeson.thread.segment01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/3/21
 * Time: 12:20
 * Description:
 */
public class ReentrantLockTest {

    static class Rthread extends Thread{

        private Lock lock;
        private String message;

        public Rthread(Lock lock,String name){
            this.lock = lock;
            this.message = name;
        }


        public String getMessage() {
            return message;
        }

        @Override
        public void run(){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+""+this.getMessage());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }


    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        Rthread t1 = new Rthread(reentrantLock, "t1");
        Rthread t2 = new Rthread(reentrantLock, "t2");
        Rthread t3 = new Rthread(reentrantLock, "t3");
        t1.start();
        t2.start();
        t3.start();
    }

}
