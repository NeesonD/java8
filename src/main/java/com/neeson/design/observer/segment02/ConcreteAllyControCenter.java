package com.neeson.design.observer.segment02;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/4
 * Time: 11:23
 * Description:
 */
public class ConcreteAllyControCenter extends AllyControlCenter {

    @Override
    public void notifyObserver(String name) {
        players.stream().filter(player -> !player.getName().equals(name))
                .forEach(p -> p.help());
    }
}
