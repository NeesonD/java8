package com.neeson.reflect;

import com.neeson.basic.domain.TheAnnotation;
import com.neeson.basic.domain.TheClass;


import java.lang.annotation.Annotation;

/**
 * Created by daile on 2017/8/7.
 */
public class MyAnnotation {

    public void getAnnotation(){
        Class aClass = TheClass.class;

        Annotation[] annotations = aClass.getAnnotations();
        Annotation theannotation = aClass.getAnnotation(TheAnnotation.class);

        for (Annotation annotation:annotations){
            if (annotation instanceof TheAnnotation){
                TheAnnotation theAnnotation = (TheAnnotation) annotation;
                System.out.println("name:"+ theAnnotation.name());
                System.out.println("value:"+ theAnnotation.value());
            }
        }
    }

}
