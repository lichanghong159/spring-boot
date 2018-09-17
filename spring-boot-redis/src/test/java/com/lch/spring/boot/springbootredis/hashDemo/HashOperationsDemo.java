package com.lch.spring.boot.springbootredis.hashDemo;

import com.lch.spring.boot.springbootredis.BaseTest;
import com.lch.spring.boot.springbootredis.entity.UserRelTeam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/9/12 15:12
 **/
public class HashOperationsDemo extends BaseTest {
    @Autowired
    private RedisTemplate redisTemplate;
    static  final String teamIdKey= "teamId:";
    @Test
    public void exist(){
        String userEmail = "test1@xdf.cn";
        HashOperations hashOperations=redisTemplate.opsForHash();
        UserRelTeam userRelTeam = new UserRelTeam();
      if(hashOperations.hasKey(teamIdKey+1, userEmail)){
          System.out.println("已经存在!");
      }else{
          userRelTeam.setId(0L);
          userRelTeam.setUserEmail(userEmail);
          userRelTeam.setTeamId(1L);
          System.out.println("插入数据库");
          hashOperations.put(teamIdKey+1, userEmail, userRelTeam.toString());
      }
    }
    @Test
    public void delete(){
        String userEmail = "test1@xdf.cn";
        HashOperations hashOperations=redisTemplate.opsForHash();
        hashOperations.delete(teamIdKey+1,userEmail);
    }
}
