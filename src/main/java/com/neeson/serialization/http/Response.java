package com.neeson.serialization.http;

import lombok.Data;

/**
 * Created by daile on 2017/9/12.
 */
@Data
public class Response {
    //编码，响应内容，响应长度
    private byte encode;
    private int responseLength;
    private String response;

}
