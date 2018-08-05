package com.neeson.thread.course5;

import java.util.concurrent.*;

/**
 * Created by daile on 2017/9/1.
 */
public class Memoizer<A,V> implements Computable<A,V> {

    private final ConcurrentHashMap<A,Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A,V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compare(final A args) throws InterruptedException {

        while (true){
            Future<V> f = cache.get(args);
            if (f == null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compare(args);
                    }
                };
                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.putIfAbsent(args,ft);
                if (f == null){
                    f= ft;
                    ft.run();
                }
                try {
                    return f.get();
                }catch (CancellationException e){
                    cache.remove(args);
                }catch (ExecutionException e){

                }
            }
        }
    }
}
