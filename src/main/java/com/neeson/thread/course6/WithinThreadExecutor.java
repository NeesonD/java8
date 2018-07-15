package com.neeson.thread.course6;

import java.util.concurrent.Executor;

/**
 *
 *在调用线程中以同步方式执行所有任务的Executor
 * Created by daile on 2017/9/1.
 */
public class WithinThreadExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
