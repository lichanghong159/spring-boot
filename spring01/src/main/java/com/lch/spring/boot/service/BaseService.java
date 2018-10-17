package com.lch.spring.boot.service;


import java.io.Serializable;

/**
 * <p>泛型依赖注入</p>
 *
 * @author lichanghong     create by   2018/10/17 14:13
 **/
public abstract class  BaseService<M extends Serializable> {
    abstract M find();
}
