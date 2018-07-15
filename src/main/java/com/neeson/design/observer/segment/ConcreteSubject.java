package com.neeson.design.observer.segment;



/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/4
 * Time: 11:07
 * Description:
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        for(Observer obs:observers){
            obs.update();
        }
    }
}
