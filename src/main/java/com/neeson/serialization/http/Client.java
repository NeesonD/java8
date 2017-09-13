package com.neeson.serialization.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by daile on 2017/9/12.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Request request = new Request();
        request.setCommand("HELLO");
        request.setCommandLength(request.getCommand().length());


        Socket socket = new Socket("127.0.0.1",4567);

        OutputStream outputStream = socket.getOutputStream();

        //ProtocolUtil.writeResponse(outputStream,request);
    }

}
