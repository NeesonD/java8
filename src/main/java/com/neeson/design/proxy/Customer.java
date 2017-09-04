package com.neeson.design.proxy;

/**
 * Created by daile on 2017/9/4.
 */
public class Customer implements BuyCar {

    private int cash;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public void buyCar() {
        System.out.println("花了" + cash + "买车");
    }
}
