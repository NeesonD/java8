package com.neeson.design.observer.segment03;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/9
 * Time: 9:00
 * Description:
 */
public class Reader implements Observer {

    private String name;

    public Reader(String name) {
        this.name = name;
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name+"你好===》"+arg.toString());
    }
}
