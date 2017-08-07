package com.neeson.Proxy;

/**
 * Created by daile on 2017/8/7.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add!!!");
    }

    @Override
    public void delete() {
        System.out.println("delete!!!");
    }
}
