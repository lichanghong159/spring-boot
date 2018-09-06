package com.lch.spring.boot.springbootlesson6.controller;

import com.lch.spring.boot.springbootlesson6.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/9/5 14:57
 **/
@RestController
public class JdbcController {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping(value = "/user/get")
    public User getUser(@RequestParam(value = "id",defaultValue = "1")int id){
        User user = new User();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps =  connection.prepareStatement("select id,name,age from user where id=?");
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
@PostMapping(value = "/user/add")
    public Boolean addUser(@RequestBody User user){
    Boolean result= jdbcTemplate.execute("INSERT INTO user(name,age) VALUES(?,?)", new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, user.getName());
                ps.setInt(2, user.getAge());
                return  ps.executeUpdate() > 0;
            }
        });
        return result;
}
}
