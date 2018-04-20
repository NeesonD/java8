package com.neeson.design.command.segment01;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 10:53
 * Description:
 */
public class Client {

    public static void main(String[] args) throws Exception {
        ConfigSettingWindow configSettingWindow = new ConfigSettingWindow();
        Command command;
        ConfigOperator configOperator = new ConfigOperator();

        command = new InsertCommand();
        command.setOperator(configOperator);
        configSettingWindow.setCommand(command);
        configSettingWindow.call("首页");

        command = new InsertCommand();
        command.setOperator(configOperator);
        configSettingWindow.setCommand(command);
        configSettingWindow.call("端口");

        command = new UpdateCommand();
        command.setOperator(configOperator);
        configSettingWindow.setCommand(command);
        configSettingWindow.call("修改端口");


        configSettingWindow.save();


        configSettingWindow.recover();
    }

}
