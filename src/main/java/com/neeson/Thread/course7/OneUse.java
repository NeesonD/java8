package com.neeson.Thread.course7;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by daile on 2017/9/8.
 */
public class OneUse {

    boolean checkMail(Set<String> hosts, long timeout, TimeUnit unit) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final AtomicBoolean hasNewMail = new AtomicBoolean(false);

        try {
            for (final String host:hosts)
                exec.execute(() -> {
                if (checkMail(host))
                    hasNewMail.set(true);
                });
        }finally {
            exec.shutdown();
            exec.awaitTermination(timeout,unit);
        }
        return hasNewMail.get();
    }

    private boolean checkMail(String host) {
        return true;
    }

}
