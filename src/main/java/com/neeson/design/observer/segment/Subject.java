package com.neeson.design.observer.segment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/4
 * Time: 10:52
 * Description:
 */
public abstract  class Subject {

    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer){
        observers.add(observer);
    }

    public void delete(Observer observer){
        observers.remove(observer);
    }


    public abstract void notifyObserver();

}
