package com.lch.spring.boot.springbootlesson7.demo;


import com.lch.spring.boot.springbootlesson7.entity.User;
import com.lch.spring.boot.springbootlesson7.entity.UserExample;
import com.lch.spring.boot.springbootlesson7.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

public class MyBatisGeneratorDemo {

    public static void main(String[] args) throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream("mybatis/mybatis-config.xml");

        Reader reader = new InputStreamReader(inputStream, "UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(reader, "dev", new Properties());

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);



       for (int i=0;i<=200;i++){
           User user = new User();
           user.setDescription("test"+i);
           user.setName("test"+i);
           if(i<20){
               user.setAge(18);
           }else{
               user.setAge(22);
           }
           userMapper.insertSelective(user);
       }
        sqlSession.commit();

        sqlSession.close();

    }

}
