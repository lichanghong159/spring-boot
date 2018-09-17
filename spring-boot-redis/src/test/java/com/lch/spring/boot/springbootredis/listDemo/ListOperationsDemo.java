package com.lch.spring.boot.springbootredis.listDemo;

import com.lch.spring.boot.springbootredis.BaseTest;
import com.lch.spring.boot.springbootredis.entity.UserRelTeam;
import com.lch.spring.boot.springbootredis.model.User;
import com.lch.spring.boot.springbootredis.repository.UserRelTeamRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>ListOperationsDemo</p>
 *
 * @author lichanghong     create by   2018/9/12 10:10
 **/
public class ListOperationsDemo extends BaseTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserRelTeamRepository repository;
    @Test
    public void leftPushInteger(){
        ListOperations<String,Integer> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list", 123);
      List<Integer> list= listOperations.range("list", 0, -1);
      list.stream().forEach(System.out::println);
    }
    @Test
    public void pushUserOne(){
        String key = "userList";
        User user = new User();
        user.setId(1);
        user.setName("aaaaa222");
        user.setAge(181);
        ListOperations<String, User> listOperations = redisTemplate.opsForList();
        listOperations.leftPush(key, user);
        listOperations.getOperations().expire(key,1, TimeUnit.DAYS);
        List<User> users = listOperations.range(key, 0, -1);
        users.forEach(System.out::println);
    }

    @Test
    public void pushUserList(){
        String key = "userList";
        List<User> users = new ArrayList<>();
        for (int i=1;i<10;i++){
            User user = new User();
            user.setId(i);
            user.setAge(20+i);
            user.setName("user"+i);
            users.add(user);
        }
        ListOperations<String, User> ops = redisTemplate.opsForList();
        long result =ops.leftPushAll(key, users);
        System.out.println(result);
    }
    @Test
    public void updateUser(){
        String key = "userList";
        ListOperations<String, User> ops = redisTemplate.opsForList();
        //下标从0开始，所以修改的是第六个
        User user = ops.index(key, 5);
        user.setName("已经修改了");
        ops.set(key, 5, user);
    }
    @Test
    public void queryUserRelTeamTest(){
        List<UserRelTeam> list = repository.findAll();
        Map<String,Map<String,List<UserRelTeam>>> mapMap = new HashMap<>();
                list.stream()
                        .collect(Collectors.groupingBy(UserRelTeam::getTeamId))
                        .forEach((key,userRelTeamList)->{
                                 Map<String, List<UserRelTeam>> userRelTeamMap = userRelTeamList
                                                            .stream()
                                                            .collect(Collectors.groupingBy(UserRelTeam::getUserEmail));
                            mapMap.put(String.valueOf(key), userRelTeamMap);
        });
        System.out.println(mapMap);
        HashOperations hashOperations= redisTemplate.opsForHash();
        String teamId="teamId";
        mapMap.forEach((key,map)->{
            map.forEach((key1,urts)->{
                System.out.println(urts.get(0));
                hashOperations.put(teamId+":"+key, key1,urts.get(0).toString());
            });
        });
    }
}
