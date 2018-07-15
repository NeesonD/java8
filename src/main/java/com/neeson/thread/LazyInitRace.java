package com.neeson.thread;

import com.neeson.thread.annotation.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {

    private Object object;

    public Object getInstance(){
        if (object == null){
            object = new Object();
        }
        return object;
    }

}
