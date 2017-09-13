package com.neeson.serialization;

import com.neeson.domain.MyObject;

import java.io.*;

/**
 * Created by daile on 2017/9/12.
 */
public class JavaSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //字节数组输出流
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //对象输出流
        ObjectOutputStream out = new ObjectOutputStream(os);
        //将对象写入到字节数组输出，进行序列化
        MyObject myObject = new MyObject("nwwson");
        out.writeObject(myObject);

        byte[] zhansanByte = os.toByteArray();

        //字节数组输入流
        ByteArrayInputStream is = new ByteArrayInputStream(zhansanByte);
        //执行反序列化，从流中读取对象
        ObjectInputStream in = new ObjectInputStream(is);

        MyObject object = (MyObject) in.readObject();
        System.out.println(object);

    }

}
