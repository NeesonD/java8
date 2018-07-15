package com.neeson.reflect;

import com.neeson.basic.domain.MyObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by daile on 2017/7/29.
 */
public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException {
        //Class对象
        Class myObjectClass = MyObject.class;

        Class clazz = Class.forName("com.neeson.basic.domain.MyObject");

        //类名
        String className = clazz.getName();

        //不包含包的类名
        String classSimpleName = clazz.getSimpleName();

        //获取修饰符，修饰符被包装成int
        int modifiers = clazz.getModifiers();

        //包信息
        Package aPackage = clazz.getPackage();


        Class superClass = clazz.getSuperclass();

        Method[] methods = clazz.getMethods();

        Field[] fields = clazz.getFields();


    }

}
