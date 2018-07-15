package com.neeson.serialization.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by daile on 2017/9/13.
 */
public class ProtocolUtil {

    public static Request readRequest(InputStream inputStream) throws IOException {
        //读取编码
        byte[] encodeByte = new byte[1];
        inputStream.read(encodeByte);
        byte encode = encodeByte[0];

        //读取命令长度
        byte[] commandLengthBytes = new byte[4];
        inputStream.read(commandLengthBytes);
        int commandLength = ByteUtil.bytes2Int(commandLengthBytes);

        //读取命令
        byte[] commandBytes = new byte[commandLength];
        inputStream.read(commandBytes);
        String command = "";

        Request request = new Request();
        request.setCommand(command);
        request.setEncode(encode);
        request.setCommandLength(commandLength);
        return request;

    }

    public static void writeResponse(OutputStream outputStream,Response response) throws IOException {
        //outputStream写入一个int，会截取其低8位，丢弃高24位，因将其转换成Big Endian
        outputStream.write(response.getEncode());
        outputStream.write(ByteUtil.int2ByteArray(response.getResponseLength()));
        outputStream.flush();
    }

}
