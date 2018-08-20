package com.lch.controller;

import com.lch.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lichanghong on 2018-08-19
 **/
@RestController
public class XmlRestDemoController {
    @GetMapping(path = "/xml/user")
    public User user(){
        User user = new User();
        user.setName("你好");
        user.setAge(12);
        return user;
    }
}
