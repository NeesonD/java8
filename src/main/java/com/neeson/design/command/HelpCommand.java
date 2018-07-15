package com.neeson.design.command;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 10:15
 * Description:
 */
public class HelpCommand extends Command {

    private HelpHandler helpHandler;

    public HelpCommand() {
        this.helpHandler = new HelpHandler();
    }

    @Override
    public void execute() {
        helpHandler.display();
    }
}
