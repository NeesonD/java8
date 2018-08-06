package com.neeson.vm.jtool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/8/6
 * Time: 23:17
 * Description:
 */
public class LockThread {

    public static void createBusyThread(){
         new Thread(() -> {
            while (true){

            }
        },"testBusyThread").start();
    }

    public static void createLockThread(Object lock){
        new Thread( () -> {
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"testLockThread").start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object lock = new Object();
        createLockThread(lock);
    }

}
