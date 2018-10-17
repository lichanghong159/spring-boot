package com.lch.spring.boot.service;

import com.lch.spring.boot.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/10/17 14:22
 **/
public class BaseServiceTest extends BaseTest {
    @Autowired
    private Map<String,BaseService> map;
    @Test
    public void mapInject(){
        System.err.println(map.get("userService").find());
        System.err.println(map.get("viewSpaceService").find());
    }
}
