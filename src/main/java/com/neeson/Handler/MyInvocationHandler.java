package com.neeson.Handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by daile on 2017/7/28.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object target){
        super();
        this.object = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//        PerformanceMonior.begin(object.getClass().getName()+"."+method.getName());

        Object result = method.invoke(object,args);

//        PerformanceMonior.end();

        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),object.getClass().getInterfaces(),this);
    }


    public static void main(String[] args) {
        Method[] methods = MyInvocationHandler.class.getMethods();
        List<Method> me = Arrays.asList(methods);
        System.out.println(me);
    }
}
