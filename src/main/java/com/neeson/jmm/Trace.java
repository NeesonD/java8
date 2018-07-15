package com.neeson.jmm;

/**
 * Create by neeson on 2018/3/2
 */
public class Trace {

    public static void main(String[] args) {
        for (int i = 0; i <100000000 ; i++) {
            new Byte("11");
        }
    }

}
