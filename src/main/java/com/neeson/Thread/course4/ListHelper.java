package com.neeson.Thread.course4;

import com.neeson.Thread.annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by daile on 2017/8/31.
 */
@NotThreadSafe
public class ListHelper<E> {

    //对list操作使用了不同的锁
    public List<E> list= Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x){
        boolean absent = !list.contains(x);
        if (absent){
            list.add(x);
        }
        return absent;
    }

}
