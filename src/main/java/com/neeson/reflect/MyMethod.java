package com.neeson.reflect;

import com.neeson.basic.domain.MyObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by daile on 2017/7/31.
 */
public class MyMethod {

    public static void method() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class aClass = MyObject.class;

        Method[] methods = aClass.getMethods();

        Method method = aClass.getMethod("doSomething",new Class[]{String.class});

        Class[] parameterTypes = method.getParameterTypes();

        Class returnType = method.getReturnType();


        //执行方法，如果是静态方法则传入null，反之传入一个对象，后面是形参
        Object returnValue = method.invoke(null,"parameter-value1");



    }

}
