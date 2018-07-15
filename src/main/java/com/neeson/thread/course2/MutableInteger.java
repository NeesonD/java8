package com.neeson.thread.course2;

import com.neeson.thread.annotation.NotThreadSafe;

/**
 * Created by daile on 2017/8/28.
 */
@NotThreadSafe
public class MutableInteger {

    private int value;

    public int get(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

}
