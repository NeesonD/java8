package com.neeson.serialization.http;

import lombok.Data;

/**
 * Created by daile on 2017/9/12.
 */
@Data
public class Request {
    //编码、命令、长度
    private byte encode;
    private String command;
    private int commandLength;

}
