package com.neeson.reflect;

import com.neeson.domain.MyObject;

import java.lang.reflect.Field;

/**
 * Created by daile on 2017/7/29.
 */
public class MyFiled {

    public static void filed() throws NoSuchFieldException, IllegalAccessException {

        Class aClass = MyObject.class;

        Field[] fields = aClass.getFields();

        Field afield = aClass.getField("someField");

        String fieldName = afield.getName();

        Object fieldType = afield.getType();

        MyObject myObject = new MyObject();

        Object value = afield.get(myObject);

        afield.set(myObject,value);

    }

}
