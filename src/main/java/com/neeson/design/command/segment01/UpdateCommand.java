package com.neeson.design.command.segment01;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 10:36
 * Description:
 */
public class UpdateCommand extends Command {
    @Override
    public void execute(String args) {
        operator.update(args);
    }

    @Override
    public void execute() {
        operator.update(this.args);
    }
}
