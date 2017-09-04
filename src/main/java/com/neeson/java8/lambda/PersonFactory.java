package com.neeson.java8.lambda;

/**
 * Created by daile on 2017/9/2.
 */
public interface PersonFactory<P extends Person> {

    P create(String firstName,String lastName);

}
