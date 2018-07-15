package com.neeson.design.observer;


/**
 * Created by daile on 2017/9/4.
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
