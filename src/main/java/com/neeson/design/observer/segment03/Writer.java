package com.neeson.design.observer.segment03;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/9
 * Time: 9:00
 * Description:
 */
public class Writer extends Observable {

    private String name;

    public Writer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void notifyObservers(Object object) {
        setChanged();
        super.notifyObservers(object);
    }
}
