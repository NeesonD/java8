package com.neeson.design.decorator.segment02;

/**
 * @author : neeson
 * Date: 2019/7/6
 * Time: 11:00
 * Description: 
 */
public class Espresso extends Beverage {

	public Espresso() {
		desc = "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}
}
