package com.neeson.Thread.course5;

/**
 * Created by daile on 2017/9/1.
 */
public interface Computable<A,V> {

    V compare(A args) throws InterruptedException;

}
