package com.neeson.Thread.course8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by daile on 2017/9/8.
 */
public class ThreadDeadLock {

    ExecutorService exec = Executors.newSingleThreadExecutor();

    public class RenderPageTask implements Callable<String> {

        @Override
        public String call() throws Exception {

            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();

            return header.get() + page + footer.get();
        }

        private String renderBody() {
            //todo
            return "";
        }

        private class LoadFileTask implements Callable<String> {
            public LoadFileTask(String a) {
            }

            @Override
            public String call() throws Exception {
                return null;
            }
        }
    }

}
