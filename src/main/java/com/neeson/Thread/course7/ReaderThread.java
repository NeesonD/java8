package com.neeson.Thread.course7;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by daile on 2017/9/8.
 */
public class ReaderThread extends Thread {

    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        try {
            socket.close();
        } catch (IOException e) {

        } finally {
            super.interrupt();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[1024];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else if (count > 0)
                    ;
            }
        } catch (IOException e) {
            //允许线程退出
        }
    }

}
