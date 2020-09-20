package com.tigerff.springboot.springbootcrud.controller;

import com.tigerff.springboot.springbootcrud.entity.CommonResult;
import com.tigerff.springboot.springbootcrud.entity.User;
import com.tigerff.springboot.springbootcrud.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/20 20:11
 */

/**
 * 这个注释就是返回的对象，springboot会自动转化为json的格式进行返回
 */
@RestController
public class DemoController {

    @Autowired
    DemoService demoService;
    @GetMapping("/demo/get/{id}")
    public CommonResult selectUserById(@PathVariable("id") Integer id)
    {
        User user = demoService.getUserById(id);

        if(user!=null)
        {
            return new CommonResult(200,"查询成功了",user);
        }
        else
            return new CommonResult(500,"没有找到",null);
    }
    @GetMapping("/demo/get/all")
    public CommonResult selectUserAll()
    {
        List<User> users = demoService.selectUserAll();
        if(users!=null)
        {
            return new CommonResult(200,"查询成功了",users);
        }
        else
            return new CommonResult(500,"没有找到",null);
    }
    @PutMapping("/demo/put/{id}")
    public CommonResult updateUserById(@PathVariable("id") Integer id,User user)
    {
        Integer integer = demoService.updateUserById(id,user.getName(),user.getSex());
        if(integer!=null&&integer==1)
        {
            return new CommonResult(200,"更新成功了",integer);
        }
        else
            return new CommonResult(500,"没有更新成功",null);
    }
    @DeleteMapping("/demo/delete/{id}")
    public CommonResult deleteUserById(@PathVariable("id") Integer id)
    {
        Integer integer = demoService.deleteUserById(id);
        if(integer!=null&&integer==1)
        {
            return new CommonResult(200,"删除成功了",integer);
        }
        else
            return new CommonResult(500,"没有删除成功",null);
    }
    @PostMapping("/demo/post")
    public CommonResult InsertUser(User user)
    {
        Integer integer = demoService.InsertUser(user);
        if(integer!=null&&integer==1)
        {
            return new CommonResult(200,"插入成功了",integer);
        }
        else
            return new CommonResult(500,"没有插入成功",null);
    }
}
