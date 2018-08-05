package com.neeson.thread.course7;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by daile on 2017/9/8.
 */
public class LogService {

    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter printWriter;
    private boolean isShutdown;
    private int reservations;

    public LogService(Writer writer){
        this.printWriter = (PrintWriter) writer;
        this.queue = new LinkedBlockingQueue<>(10);
        this.loggerThread = new LoggerThread();
    }

    public void start() {
        loggerThread.start();
    }

    private class LoggerThread extends Thread {

        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutdown && reservations == 0)
                                break;
                        }
                        String msg = queue.take();
                        synchronized (LogService.this) {
                            --reservations;
                        }
                        printWriter.println(msg);
                    } catch (InterruptedException e) {

                    }
                }
            } finally {
                printWriter.close();
            }
        }

    }



}
