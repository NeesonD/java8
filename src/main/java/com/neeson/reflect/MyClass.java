package com.neeson.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daile on 2017/8/7.
 */
public class MyClass {

    protected List<String> stringList = new ArrayList<>();

    public List<String> getStringList() {
        return this.stringList;
    }

    public void setStringList(List<String> list) {
        this.stringList = list;
    }

    public void getReturnTypeArg() throws NoSuchMethodException {

        Method method = MyClass.class.getMethod("getStringList");

        Type returnType = method.getReturnType();

        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            Type[] types = parameterizedType.getActualTypeArguments();

            for (Type type : types) {
                Class typeArgClass = (Class) type;

                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
    }

    public void getParameterTypes() throws NoSuchMethodException {

        Method method = MyClass.class.getMethod("setStringList", List.class);

        Type[] genericParametertypes = method.getGenericParameterTypes();

        for (Type genericparameterType : genericParametertypes) {
            if (genericparameterType instanceof ParameterizedType) {
                ParameterizedType atype = (ParameterizedType) genericparameterType;
                Type[] types = atype.getActualTypeArguments();
                for (Type type : types) {
                    Class parameterArgClass = (Class) type;
                    System.out.println("parameterArgTypes = " + parameterArgClass);
                }
            }
        }
    }

    public void getFieldTypes() throws NoSuchFieldException {
        Field field = MyClass.class.getField("stringList");
        Type genericFieldType = field.getGenericType();
        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            for (Type fieldArgType : fieldArgTypes) {
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }
    }

}
