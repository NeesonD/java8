package com.neeson.Thread.course3;

import com.neeson.Thread.annotation.ThreadSafe;

import java.util.Vector;

/**
 *
 * 在现有线程安全类中添加功能
 * Created by daile on 2017/8/30.
 *
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {

    public synchronized boolean putIfAbsent(E x){
        boolean absent = !contains(x);
        if (absent){
            add(x);
        }
        return absent;
    }

}
