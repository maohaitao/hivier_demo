package com.bike.user.entity;

import java.io.Serializable;

/**
 * Created by a700 on 16/9/23.
 */
public class Student implements  Serializable {
    private  String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
