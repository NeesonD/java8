package com.neeson.design.command.segment02;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 9:56
 * Description:
 */
public  class FunctionButton {

    private String name;
    private Command command;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onClick(){
        command.execute();
    }
}
