package com.neeson.proxy;

import org.assertj.core.internal.cglib.core.DebuggingClassWriter;

/**
 * Created by daile on 2017/8/7.
 */
public class Cglib {

    public void testCglibProxy(){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/daile/Downloads");
        UserServiceImpl userService = new UserServiceImpl();
        CglibProxy cglibProxy = new CglibProxy();
        UserService proxy = (UserService) cglibProxy.getProxy(userService);
        proxy.add();

    }

}
