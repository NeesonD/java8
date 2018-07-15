package com.neeson.design.observer.segment04;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/10
 * Time: 8:40
 * Description:
 */
public class Client {

    public static void main(String[] args) {
        ButtonJsp buttonJsp = new ButtonJsp();
        buttonJsp.getButton().dbClick();
        buttonJsp.getButton().click();
        buttonJsp.getButton().mouseMove();

    }
}
