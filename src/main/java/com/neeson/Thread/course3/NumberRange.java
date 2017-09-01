package com.neeson.Thread.course3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by daile on 2017/8/30.
 */
public class NumberRange {

    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void serLower(int i){
        //不安全的"先检查在执行"
        if (i>upper.get()){
            throw new IllegalArgumentException("can't set lower to"+i+"> upper");
        }
        lower.set(i);
    }

    public void setUpper(int i){
        if (i<lower.get()){
            throw new IllegalArgumentException("cant't set upper to "+i+"< lower");
        }
        upper.set(i);
    }

    public boolean isinRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }

}
