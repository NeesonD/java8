package com.neeson.design.decorator.segment02;

/**
 * @author : neeson
 * Date: 2019/7/6
 * Time: 11:02
 * Description: 
 */
public class Mocha extends CondimentDecorator {

	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDesc() {
		return beverage.getDesc() + " | mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}
}
