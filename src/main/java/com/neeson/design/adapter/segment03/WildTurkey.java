package com.neeson.design.adapter.segment03;

/**
 * @author : neeson
 * Date: 2019/7/3
 * Time: 22:58
 * Description: 
 */
public class WildTurkey implements Turkey {
	@Override
	public void gobble() {
		System.out.println("Gobble gobble");
	}

	@Override
	public void fly() {
		System.out.println("flying short");
	}
}
