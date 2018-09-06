package com.lch.spring.boot.springbootlesson7.annotation;

import com.lch.spring.boot.springbootlesson7.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @createby lichanghong on 2018-09-06 21:48
 **/
@Mapper
public interface UserMapper {
    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "description", column = "description")
    })
    @Select("SELECT id,name,age,description FROM user WHERE id = #{id}")
    User selectUser(int id);
}
