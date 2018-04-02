package com.neeson.design.decorator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/2
 * Time: 10:50
 * Description:
 */
public class Skill_W extends Skills {

    private String skillName;

    public Skill_W(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了W");
        super.learnSkills();
    }
}
