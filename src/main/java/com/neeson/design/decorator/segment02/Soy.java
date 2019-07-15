package com.neeson.design.decorator.segment02;

/**
 * @author : neeson
 * Date: 2019/7/6
 * Time: 11:03
 * Description: 
 */
public class Soy extends CondimentDecorator {

	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDesc() {
		return beverage.getDesc() + " | soy";
	}

	@Override
	public double cost() {
		return 0.4 + beverage.cost();
	}
}
