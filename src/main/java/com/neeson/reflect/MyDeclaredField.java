package com.neeson.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by daile on 2017/8/7.
 */
public class MyDeclaredField {

    private String privateString = null;

    public MyDeclaredField(String privateString) {
        this.privateString = privateString;
    }

    public String getPrivateString(){
        return this.privateString;
    }

    public void getDeclaredFiled() throws NoSuchFieldException, IllegalAccessException {
        MyDeclaredField myDeclaredField = new MyDeclaredField("Private value");

        Field privateStringField = MyDeclaredField.class.getDeclaredField("privateString");

        privateStringField.setAccessible(true);

        String fieldValue = (String) privateStringField.get(myDeclaredField);

        System.out.println("fieldValue = " + fieldValue);
    }

    public void getDeclaredMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        MyDeclaredField myDeclaredField = new MyDeclaredField("...");

        Method privateMethod = MyDeclaredField.class.getDeclaredMethod("getPrivateString",null);

        privateMethod.setAccessible(true);

        String returnValue = (String) privateMethod.invoke(myDeclaredField,null);

        System.out.println("returnValue = " + returnValue);

    }


}
