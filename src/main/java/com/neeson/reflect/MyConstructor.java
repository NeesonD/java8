package com.neeson.reflect;

import com.neeson.basic.domain.MyObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by daile on 2017/7/29.
 */
public class MyConstructor {

    public static void contruct() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class aClass = MyObject.class;

        Constructor[] constructors = aClass.getConstructors();

        Constructor constructor = aClass.getConstructor(new Class[]{String.class});

        Class[] parameterTypes = constructor.getParameterTypes();

        MyObject myObject = (MyObject) constructor.newInstance();

    }


}
