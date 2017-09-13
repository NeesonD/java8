package com.neeson.serialization.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by daile on 2017/9/12.
 */
public class Consumer {

    public static void main(String[] args) throws NoSuchMethodException, IOException, ClassNotFoundException {
        String interfacename = SayHelloService.class.getName();
        Method method = SayHelloService.class.getMethod("sayHello", String.class);

        Object[] arguments = {"hello"};

        Socket socket = new Socket("127.0.0.1",1234);

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeUTF(interfacename);
        outputStream.writeUTF(method.getName());
        outputStream.writeObject(method.getParameterTypes());
        outputStream.writeObject(arguments);

        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Object result = inputStream.readObject();
    }

}
