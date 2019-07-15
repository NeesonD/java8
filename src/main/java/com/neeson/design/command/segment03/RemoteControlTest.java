package com.neeson.design.command.segment03;

/**
 * @author : neeson
 * Date: 2019/7/7
 * Time: 10:47
 * Description: 
 */
public class RemoteControlTest {

	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light(){
			@Override
			public void on() {
				System.out.println("开灯");
			}

			@Override
			public void off() {
				System.out.println("关灯");
			}
		};
		Command lightOnCommand = new LightOnCommand(light);
		remote.setCommand(lightOnCommand);
		remote.buttonWasPressed();
	}

}
