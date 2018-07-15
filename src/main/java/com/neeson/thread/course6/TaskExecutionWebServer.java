package com.neeson.thread.course6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by daile on 2017/9/1.
 */
public class TaskExecutionWebServer {

    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(82);
        while (true){
            final Socket socket = serverSocket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //TODO
                }
            };
            exec.execute(task);
        }
    }

}
