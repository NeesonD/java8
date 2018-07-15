package com.neeson.Thread.segment01;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/19
 * Time: 16:04
 * Description:
 */
public class Thread3 extends Thread {

    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread3 thread3 = new Thread3();
        thread3.start();
        Thread.sleep(100);
        thread3.interrupt();
    }

}
