package com.tigerff.springboot.springbootcrud.service;

import com.tigerff.springboot.springbootcrud.dao.DemoDao;
import com.tigerff.springboot.springbootcrud.entity.CommonResult;
import com.tigerff.springboot.springbootcrud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/20 20:12
 */
@Service
public class DemoService {
    @Autowired
    DemoDao demoDao;
    public User getUserById(Integer id)
    {
       return demoDao.getUserById(id);

    }
    public List<User> selectUserAll()
    {
        return demoDao.getUserAll();
    }
    public Integer updateUserById(Integer id,String name,String sex)
    {
       return demoDao.UpdateUserById(id,name,sex);
    }
    public Integer deleteUserById(Integer id)
    {
        return demoDao.deleteUserById(id);
    }
    public Integer InsertUser(User user)
    {
        return demoDao.InsertUser(user);
    }
}
