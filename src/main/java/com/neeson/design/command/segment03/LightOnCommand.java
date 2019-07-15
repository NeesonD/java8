package com.neeson.design.command.segment03;

/**
 * @author : neeson
 * Date: 2019/7/7
 * Time: 10:42
 * Description: 
 */
public class LightOnCommand implements Command {

	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}
}
