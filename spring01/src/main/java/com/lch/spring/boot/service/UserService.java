package com.lch.spring.boot.service;

import com.lch.spring.boot.model.User;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/10/17 14:17
 **/
@Service(value = "userService")
public class UserService extends BaseService<User> {
    @Override
    User find() {
        User user = new User();
        user.setAge(20);
        user.setName("user");
        return user;
    }
}
