package com.neeson.Thread.course5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daile on 2017/9/1.
 */
public class Memoizerl<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizerl(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compare(A args) throws InterruptedException {
        V result = cache.get(args);
        if (result == null) {
            result = c.compare(args);
            cache.put(args, result);
        }
        return result;
    }
}
