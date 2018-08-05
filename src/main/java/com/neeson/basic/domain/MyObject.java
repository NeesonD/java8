package com.neeson.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by daile on 2017/7/29.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyObject implements Serializable{

    private String name;

}
