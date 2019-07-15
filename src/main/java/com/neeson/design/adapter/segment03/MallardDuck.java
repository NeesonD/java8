package com.neeson.design.adapter.segment03;

/**
 * @author : neeson
 * Date: 2019/7/3
 * Time: 22:56
 * Description: 
 */
public class MallardDuck implements Duck {
	@Override
	public void quack() {
		System.out.println("Quack");
	}

	@Override
	public void fly() {
		System.out.println("flying");
	}
}
