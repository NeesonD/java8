package com.neeson.Thread.course6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 每次只能处理一个请求
 * Created by daile on 2017/9/1.
 */
public class SingleThreadWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true){
            Socket socket = serverSocket.accept();
            handleRequest(socket);
        }
    }

    static void handleRequest(Socket socket){

    }

}
