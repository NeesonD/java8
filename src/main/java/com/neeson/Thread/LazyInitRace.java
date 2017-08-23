package com.neeson.Thread;

import com.neeson.Thread.annotation.NotThreadSafe;

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
