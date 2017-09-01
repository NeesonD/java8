package com.neeson.Thread.course6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 为每个请求建立一个线程
 * Created by daile on 2017/9/1.
 */
public class ThreadPerTaskWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(81);
        while (true){
            final Socket socket = serverSocket.accept();
            Runnable task  = new Runnable() {
                @Override
                public void run() {
                    //TODO
                }
            };
            new Thread(task).start();
        }
    }

}
