package com.neeson.thread.course6;

import java.util.concurrent.Executor;

/**
 * 为每个请求建立新线程
 * Created by daile on 2017/9/1.
 */
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
