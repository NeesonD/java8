package com.neeson.design.observer.segment02;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/4
 * Time: 11:31
 * Description:
 */
public class Client {

    public static void main(String[] args) {
        AllyControlCenter acc = new ConcreteAllyControCenter();
        acc.setAllyName("金庸群侠");

        Observer p1,p2,p3,p4;
        p1 = new Player("p1");
        p2 = new Player("p2");
        p3 = new Player("p3");
        p4 = new Player("p4");

        acc.join(p1);
        acc.join(p2);
        acc.join(p3);
        acc.join(p4);

        p1.beAttacked(acc);

    }

}
