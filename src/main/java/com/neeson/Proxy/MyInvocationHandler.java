package com.neeson.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by daile on 2017/8/7.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target,args);
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        UserService service = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        UserService proxy = (UserService) handler.getProxy();
        proxy.add();
        proxy.delete();
    }
}
