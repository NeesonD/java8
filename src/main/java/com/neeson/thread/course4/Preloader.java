package com.neeson.thread.course4;

import com.neeson.basic.domain.ProductInfo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by daile on 2017/8/31.
 */
public class Preloader {

    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            return null;
        }
    });

    private final Thread thread = new Thread(future);

    public void start(){
        thread.start();
    }

    public ProductInfo get() throws Throwable {
        try {
            return future.get();
        }catch (ExecutionException e){
            Throwable cause = e.getCause();
            if (cause instanceof Exception)
                throw cause;

        }
        return null;
    }

}
