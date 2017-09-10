package com.neeson.Thread.course9;

/**
 * Create by neeson on 2017/9/10
 */
public class LeftRightDeadLock {

    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight(){
        synchronized (left){
            synchronized (right){
                //TODO
            }
        }
    }

    public void RightLeft(){
        synchronized (right){
            synchronized (left){
                //TODO
            }
        }
    }

}
