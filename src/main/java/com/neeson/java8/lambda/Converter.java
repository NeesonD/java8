package com.neeson.java8.lambda;

/**
 *
 * @author daile
 * @date 2017/9/2
 */
@FunctionalInterface
public interface Converter<F, T> {

	T convert(F from);

}
