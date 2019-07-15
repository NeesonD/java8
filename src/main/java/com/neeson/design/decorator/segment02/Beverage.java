package com.neeson.design.decorator.segment02;

/**
 * @author : neeson
 * Date: 2019/7/6
 * Time: 10:57
 * Description: 
 */
public abstract class Beverage {

	String desc = "Unknown Beverage";

	public String getDesc() {
		return desc;
	}

	public abstract double cost();

}
