package com.lch.spring.boot.springbootredis.repository;

import com.lch.spring.boot.springbootredis.BaseTest;
import com.lch.spring.boot.springbootredis.entity.UserRelTeam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/9/12 11:21
 **/
public class UserRelTeamRepositoryTest extends BaseTest {
    @Autowired
    private UserRelTeamRepository repository;
    @Test
    public void findAllTest(){
        List<UserRelTeam> its = repository.findAll();
        its.forEach(System.out::println);
    }

    @Test
    public void existsByTeamIdAndUserEmailTest(){
        Long id = 3L;
        String userEmail = "zhangzhen16@xdf.cn";
        System.out.println(repository.existsByTeamIdAndUserEmail(id, userEmail));
    }
}
