package com.neeson.Thread.course7;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * Created by daile on 2017/9/8.
 */
public interface CancellableTask<T> extends Callable<T> {

    void cancel();
    RunnableFuture<T> newTask();

}
