package com.neeson.Thread.course5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by daile on 2017/9/1.
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compare(A args) throws InterruptedException {
        V result = cache.get(args);
        if (result == null) {
            result = c.compare(args);
            cache.put(args, result);
        }
        return result;
    }
}
