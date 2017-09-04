package com.neeson.design.proxy;

/**
 * Created by daile on 2017/9/4.
 */
public class CglibTest {

    public static void main(String[] args) {
        Customer customer = new Customer();
        Customer customer1 = (Customer) new ProxyFactory(customer).getProxyInstance();
        customer.buyCar();

    }

}
