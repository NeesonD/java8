package com.neeson.design.command.segment01;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 10:30
 * Description:
 */
public abstract class Command implements Serializable {

    protected String name;
    protected String args;
    protected ConfigOperator operator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperator(ConfigOperator operator){
        this.operator = operator;
    }

    public abstract void execute(String args);
    public abstract void execute();
}
