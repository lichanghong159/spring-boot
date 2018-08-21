package com.lch.controller;

import com.lch.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lichanghong on 2018-08-19
 **/
@RestController
public class JsonRestDemoController {
    /**
     * produces返回指定的媒体类型
     * consumes接收指定的媒体类型
     * @return
     */
    @GetMapping(path = "/json/user")
    public User user(){
        User user = new User();
        user.setName("你好");
        user.setAge(12);
        return user;
    }
}
