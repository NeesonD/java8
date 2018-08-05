package com.neeson.reflect;

import com.neeson.domain.ClassAnnotation;
import com.neeson.domain.MethodAnnotation;
import com.neeson.domain.TheClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by daile on 2017/8/7.
 */
public class MyAnnotation {

    public static void  main(String args[]){
        Class aClass = TheClass.class;

        Method[] methods = aClass.getMethods();
        System.out.println(String.format("method 数量 [%s]",methods.length));
        for (Method method : methods) {
            System.out.println(method.getName());
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof MethodAnnotation){
                    MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;
                    System.out.println(String.format("注解参数 [%s]",methodAnnotation.desc()));
                }
            }
        }

        Annotation[] annotations = aClass.getAnnotations();
        System.out.println(annotations.length);
        Annotation theannotation = aClass.getAnnotation(ClassAnnotation.class);

        for (Annotation annotation:annotations){
            if (annotation instanceof ClassAnnotation){
                ClassAnnotation theAnnotation = (ClassAnnotation) annotation;
                System.out.println("name:"+ theAnnotation.name());
                System.out.println("value:"+ theAnnotation.value());
            }
        }
    }

}
