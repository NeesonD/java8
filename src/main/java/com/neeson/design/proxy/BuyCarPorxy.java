package com.neeson.design.proxy;

/**
 * 静态代理
 * Created by daile on 2017/9/4.
 */
public class BuyCarPorxy implements BuyCar {

    private Customer customer;

    public BuyCarPorxy(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void buyCar() {
        if (customer.getCash() <1000000){
            System.out.println("钱不够");
            return;
        }
        customer.buyCar();
    }
}
