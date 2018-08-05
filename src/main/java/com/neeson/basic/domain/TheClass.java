package com.neeson.basic.domain;

import com.neeson.domain.ClassAnnotation;
import com.neeson.domain.MethodAnnotation;

/**
 * Created by daile on 2017/8/7.
 */
@ClassAnnotation(name = "neeson", value = "yooooooo")
public class TheClass {
    @MethodAnnotation(desc = "desc")
    public void method() {

    }

}
