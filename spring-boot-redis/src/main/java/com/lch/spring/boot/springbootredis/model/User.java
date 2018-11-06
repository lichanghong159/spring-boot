package com.lch.spring.boot.springbootredis.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.*;
import java.util.stream.Collectors;


/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/9/12 10:16
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User  {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Set<Integer> result = new HashSet<Integer>();
        Set<Integer> set1 = new HashSet<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };

        Set<Integer> set2 = new HashSet<Integer>() {
            {

                add(5);
                add(6);

            }
        };

        result.addAll(set1);
        result.addAll(set2);
        result.removeAll(set1);
        System.out.println("并集111：" + result);
    }
}
