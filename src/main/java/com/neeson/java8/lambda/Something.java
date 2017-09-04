package com.neeson.java8.lambda;

/**
 * Created by daile on 2017/9/2.
 */
public class Something {

    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    public static void main(String[] args) {

        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("java");
        System.out.println(converted);         

    }

}
