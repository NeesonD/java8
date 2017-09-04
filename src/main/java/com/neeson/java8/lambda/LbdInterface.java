package com.neeson.java8.lambda;

/**
 * Created by daile on 2017/9/2.
 */
public class LbdInterface {

    public static void main(String[] args) {

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

        Converter<String,Integer> converter1 = Integer::valueOf;
        Integer converted2 = converter1.convert("345");

        System.out.println(converted2);

    }


}
