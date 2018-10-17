package com.lch.spring.boot.model;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/10/17 14:15
 **/
public class User implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
