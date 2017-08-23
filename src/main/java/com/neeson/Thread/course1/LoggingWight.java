package com.neeson.Thread.course1;

public class LoggingWight extends Wight {

    @Override
    public synchronized void doSomething(){
        System.out.println(toString()+": calling doSomething");
        super.doSomething();
    }

}
