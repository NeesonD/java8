package com.neeson.design.observer.segment03;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/9
 * Time: 9:02
 * Description:
 */
public class Client {

    public static void main(String[] args) {
        Observer reader1 = new Reader("张三");
        Observer reader2 = new Reader("李四");
        Observable writer = new Writer("neeson");
        writer.addObserver(reader1);
        writer.addObserver(reader2);
        writer.notifyObservers("章节已更新，请查看");
    }

}
