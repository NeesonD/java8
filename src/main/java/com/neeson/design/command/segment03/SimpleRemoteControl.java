package com.neeson.design.command.segment03;

/**
 * @author : neeson
 * Date: 2019/7/7
 * Time: 10:46
 * Description: 
 */
public class SimpleRemoteControl {

	Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void buttonWasPressed() {
		command.execute();
	}

}
