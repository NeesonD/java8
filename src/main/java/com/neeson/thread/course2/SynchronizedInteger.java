package com.neeson.thread.course2;

import com.neeson.thread.annotation.ThreadSafe;

/**
 * Created by daile on 2017/8/28.
 */
@ThreadSafe
public class SynchronizedInteger {

    private int value;

    public synchronized int get(){
        return value;
    }

    public synchronized void setValue(){
        this.value = value;
    }

}
