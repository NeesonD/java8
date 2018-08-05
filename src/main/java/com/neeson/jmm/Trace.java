package com.neeson.jmm;

/**
 * Create by neeson on 2018/3/2
 * @author neeson
 */
public class Trace {

	private static final int INT = 100000000;

	public static void main(String[] args) {
        for (int i = 0; i < INT; i++) {
            new Byte("11");
        }
    }

}
