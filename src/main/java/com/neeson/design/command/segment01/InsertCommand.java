package com.neeson.design.command.segment01;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 10:33
 * Description: 增加命令
 */
public class InsertCommand extends Command {
    @Override
    public void execute(String args) {
        this.args = args;
        operator.insert(args);
    }

    @Override
    public void execute() {
        operator.insert(this.args);
    }
}
