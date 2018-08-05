package com.neeson.thread.segment01;

/**
 * Created with IntelliJ IDEA.
 * User: neeson
 * Date: 2018/3/17
 * Time: 10:34
 * Description:
 */
public class MyThread extends Thread {

    private static int num  = 0;

    public MyThread() {
        super();
        num++;
    }

    public MyThread(String name){
        super(name);
        num++;
    }

    @Override
    public void run(){
        System.out.println("主动创建的线程个数："+num);
    }
}
