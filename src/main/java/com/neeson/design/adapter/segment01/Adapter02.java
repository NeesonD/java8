package com.neeson.design.adapter.segment01;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/13
 * Time: 9:14
 * Description:
 */
public class Adapter02 implements Target {

    private Adaptee adaptee;

    public Adapter02(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void sampleMethod1() {
        adaptee.sampleMethod1();
    }

    @Override
    public void sampleMethod2() {

    }
}
