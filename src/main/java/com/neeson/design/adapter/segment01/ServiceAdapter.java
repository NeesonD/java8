package com.neeson.design.adapter.segment01;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/13
 * Time: 9:22
 * Description:不准备实现接口所有的方法时，可以提供一个默认的适配
 */
public class ServiceAdapter implements AbstractService {
    @Override
    public void service1() {

    }

    @Override
    public int service2() {
        return 0;
    }

    @Override
    public String service3() {
        return null;
    }
}
