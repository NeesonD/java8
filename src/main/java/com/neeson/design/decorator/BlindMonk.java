package com.neeson.design.decorator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/2
 * Time: 10:45
 * Description: 具体的英雄(ConcreteComponent)
 */
public class BlindMonk implements Hero {

    private String name;

    public BlindMonk(String name) {
        this.name = name;
    }

    @Override
    public void learnSkills() {
        System.out.println(name + "学习了技能");
    }


}
