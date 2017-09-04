package com.neeson.java8.lambda;

/**
 * Created by daile on 2017/9/2.
 */
@FunctionalInterface
public interface Converter<F,T> {

    T convert(F from);

}
