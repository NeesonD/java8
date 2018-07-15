package com.neeson.serialization.tcp;

/**
 * Created by daile on 2017/9/12.
 */
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String helloArg) {
        return "hello";
    }
}
