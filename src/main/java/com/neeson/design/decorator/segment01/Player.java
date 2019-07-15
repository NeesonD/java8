package com.neeson.design.decorator.segment01;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/2
 * Time: 10:57
 * Description:
 */
public class Player {

    public static void main(String[] args) {
        BlindMonk monk = new BlindMonk("瞎子");
        Skills q = new Skill_Q(monk,"q");
        Skills w = new Skill_W(monk,"w");
        q.learnSkills();
        w.learnSkills();
    }

}
