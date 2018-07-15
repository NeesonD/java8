package com.neeson.design.command.segment01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 10:39
 * Description:
 */
public class ConfigSettingWindow {

    private List<Command> commands = new ArrayList<>();
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call(String args){
        command.execute(args);
        commands.add(command);
    }

    public void save() throws Exception {
        FileUtil.writeCommand(commands);
    }

    public void recover() throws Exception {
        List<Command> list = FileUtil.readCommands();
        for (Command o : list) {
            o.execute();
        }
    }

}
