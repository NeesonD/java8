package com.neeson.design.decorator.segment02;

/**
 * @author : neeson
 * Date: 2019/7/6
 * Time: 11:01
 * Description: 
 */
public class HouseBlend extends Beverage {

	public HouseBlend() {
		desc = "HouseBlend";
	}

	@Override
	public double cost() {
		return 0.88;
	}
}
