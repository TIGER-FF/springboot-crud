package com.tigerff.springboot.springbootcrud.dao;

import com.tigerff.springboot.springbootcrud.entity.CommonResult;
import com.tigerff.springboot.springbootcrud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/20 20:12
 */
@Repository
public class DemoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public User getUserById(Integer id)
    {
        User user = jdbcTemplate.queryForObject("select * from USER where id = ?",new BeanPropertyRowMapper<User>(User.class), new Object[]{id});
        return user;
    }

    public List<User> getUserAll()
    {
        List<User> users = jdbcTemplate.query("select * from user",new Object[]{},new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
    public Integer UpdateUserById(Integer id,String name,String sex)
    {

        if(name==null) {
            return jdbcTemplate.update("UPDATE user SET sex = ? WHERE id = ?",  sex, id);
        }
        if(sex==null) {
            return jdbcTemplate.update("UPDATE user SET name = ? WHERE id = ?",  name, id);
        }
        return jdbcTemplate.update("UPDATE user SET name = ?, sex = ? WHERE id = ?", name, sex, id);
    }
    public Integer deleteUserById(Integer id)
    {
        int update = jdbcTemplate.update("delete from user where id = ?", id);
        return update;
    }
    public Integer InsertUser(User user)
    {
        int update = jdbcTemplate.update("insert into USER(NAME,sex) values(?, ?)", user.getName(), user.getSex());
        return update;
    }
}
