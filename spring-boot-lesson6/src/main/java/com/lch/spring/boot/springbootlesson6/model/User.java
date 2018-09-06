package com.lch.spring.boot.springbootlesson6.model;

/**
 * <p>用户实体</p>
 *
 * @author lichanghong     create by   2018/9/5 14:56
 **/
public class User {
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
