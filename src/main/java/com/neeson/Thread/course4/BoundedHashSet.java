package com.neeson.Thread.course4;

import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * Created by daile on 2017/8/31.
 */
public class BoundedHashSet<T> {

    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(Set<T> set, Semaphore sem) {
        this.set = set;
        this.sem = sem;
    }


    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        }finally {
            if (!wasAdded)
                sem.release();
        }
    }

    public boolean remove(Object o){
        boolean wasRemoved = set.remove(o);
        if (wasRemoved)
            sem.release();
        return wasRemoved;
    }
}
