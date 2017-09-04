package com.neeson.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by daile on 2017/9/4.
 */
public class DynamicProxy implements InvocationHandler {

    Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //before doSomething()

        Object result = method.invoke(this.obj,args);

        //after doSomething()

        return result;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        InvocationHandler handler = new DynamicProxy(customer);
        /*
        当前目标对象使用类加载器
        目标对象实现的接口类型
        事件处理，执行目标对象的方法时，会触发事件处理器的方法，会把当前执行目标对象的方法作为参数传入
         */
        BuyCar buyCar = (BuyCar) Proxy.newProxyInstance(customer.getClass().getClassLoader(),customer.getClass().getInterfaces(),handler);
        System.out.println(buyCar.getClass());
        buyCar.buyCar();

    }

}
