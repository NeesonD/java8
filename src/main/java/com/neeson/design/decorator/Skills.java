package com.neeson.design.decorator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/2
 * Time: 10:47
 * Description:技能(Decorator)
 */
public abstract class Skills implements Hero {

    private Hero hero;

    public Skills(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void learnSkills() {
        if (hero != null){
            hero.learnSkills();
        }
    }

}
