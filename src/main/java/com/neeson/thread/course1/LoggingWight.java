package com.neeson.thread.course1;

public class LoggingWight extends Wight {

    @Override
    public synchronized void doSomething(){
        System.out.println(toString()+": calling doSomething");
        super.doSomething();
    }

}
