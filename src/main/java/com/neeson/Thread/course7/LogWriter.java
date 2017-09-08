package com.neeson.Thread.course7;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by daile on 2017/9/8.
 */
public class LogWriter {

    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;

    public LogWriter(Writer writer) {
        this.queue = new LinkedBlockingQueue<>(10);
        this.loggerThread = new LoggerThread((PrintWriter) writer);
    }

    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        public LoggerThread(PrintWriter writer) {
            this.writer = writer;
        }

        public void run() {
            try {
                while (true)
                    writer.println(queue.take());
            } catch (InterruptedException e) {

            } finally {
                writer.close();
            }
        }
    }

}
