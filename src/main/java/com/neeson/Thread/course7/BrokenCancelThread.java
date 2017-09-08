package com.neeson.Thread.course7;

import java.util.concurrent.*;

/**
 * Created by daile on 2017/9/8.
 */
public class BrokenCancelThread {

    private static final ScheduledExecutorService cancelExec = new ScheduledThreadPoolExecutor(10);

    public static void timeRun(Runnable r, long timeout, TimeUnit unit) {
        final Thread taskThread = Thread.currentThread();
        cancelExec.schedule(() -> taskThread.interrupt(), timeout, unit);
        r.run();
    }


    //safeCancelThread
    public static void timeRun1(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        class RethrowableTask implements Runnable {
            private volatile Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            void rethrow() {
                if (t != null)
                    ;
            }
        }

        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(() -> taskThread.interrupt(), timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }

    public static void timeRun2(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        Future task = cancelExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            //接下来任务将被取消
        } catch (ExecutionException e) {

        } finally {
            task.cancel(true);
        }
    }


}
