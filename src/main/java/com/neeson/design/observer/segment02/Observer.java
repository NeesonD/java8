package com.neeson.design.observer.segment02;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/4
 * Time: 11:15
 * Description:
 */
public interface Observer {

    String getName();

    void setName(String name);

    void help();

    void beAttacked(AllyControlCenter allyControlCenter);

}
