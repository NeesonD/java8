package com.neeson.design.decorator.segment02;

/**
 * @author : neeson
 * Date: 2019/7/6
 * Time: 11:04
 * Description: 
 */
public class StarbuzzCoffee {

	public static void main(String[] args) {

		Beverage beverage1 = new HouseBlend();

		Beverage beverage = new Soy(new Mocha(new Mocha(beverage1)));

		System.out.println(beverage.getDesc());
		System.out.println(beverage.cost());
	}

}
