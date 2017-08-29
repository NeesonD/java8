package com.neeson.Thread.course2;

/**
 * Created by daile on 2017/8/28.
 */
public class Novisiblity {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

}
