package com.neeson.Thread.course5;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by daile on 2017/9/1.
 */
public class Memoizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compare(final A args) throws InterruptedException {
        Future<V> f = cache.get(args);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compare(args);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(args, ft);
            ft.run();
        }
        try {
            return f.get();
        } catch (ExecutionException e) {

        }

        return null;
    }
}
