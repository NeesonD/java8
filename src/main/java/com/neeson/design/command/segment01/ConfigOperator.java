package com.neeson.design.command.segment01;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/4/20
 * Time: 10:31
 * Description:
 */
public class ConfigOperator implements Serializable {

    public void insert(String args) {
        System.out.println("增加：" + args);
    }



   public void update(String args){
       System.out.println("更新："+args);
   }
}
