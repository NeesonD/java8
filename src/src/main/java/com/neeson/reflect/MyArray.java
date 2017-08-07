package com.neeson.reflect;

import java.lang.reflect.Array;

/**
 * Created by daile on 2017/8/7.
 */
public class MyArray {

    public void reflectArray() throws ClassNotFoundException {
        int[] ints = (int[]) Array.newInstance(int.class,3);
        Array.set(ints,0,111);
        Array.set(ints,1,222);
        Array.set(ints,2,333);

        System.out.println(Array.get(ints,0));
        System.out.println(Array.get(ints,1));
        System.out.println(Array.get(ints,2));


        Class StringArrayClass = String[].class;

        Class intArray = Class.forName("[I");

        Class stringArrayClass = Class.forName("Ljava.lang.String");


    }
}
