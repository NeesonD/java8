package com.neeson.basic.domain;

import com.neeson.basic.annotation.ClassAnnotation;
import com.neeson.basic.annotation.MethodAnnotation;

/**
 * Created by daile on 2017/8/7.
 */
@ClassAnnotation(name = "neeson", value = "yooooooo")
public class TheClass {
    @MethodAnnotation(desc = "desc")
    public void method() {

    }

}
