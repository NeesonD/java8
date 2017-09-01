package com.neeson.Thread.course5;

/**
 * Created by daile on 2017/9/1.
 */
public class ExpensivePunction implements Computable<String,Integer> {
    @Override
    public Integer compare(String args) throws InterruptedException {
        return new Integer(args);
    }
}
