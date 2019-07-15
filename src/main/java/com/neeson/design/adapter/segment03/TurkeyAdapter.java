package com.neeson.design.adapter.segment03;

/**
 * @author : neeson
 * Date: 2019/7/3
 * Time: 22:59
 * Description: 
 */
public class TurkeyAdapter implements Duck {

	Turkey turkey;

	@Override
	public void quack() {

	}

	@Override
	public void fly() {
		turkey.fly();
	}
}
