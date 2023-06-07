package com.czy.controller;
 
import com.czy.service.UserService;
import com.czy.util.UserInfoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

/**
 * 用户信息控制器
 * @author chenzy
 **/
@Controller
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController
{
    @Autowired
    private UserService userService;

    private UserInfoUtil userInfoUtil;

    @PostConstruct
    public void init() {
        com.czy.entity.UserInfo userInfo = userService.getUserById(1);
        userInfoUtil = new UserInfoUtil(userInfo);
    }
 
    @ApiOperation(value = "获取用户信息")
    @GetMapping("getUserById")
    public ModelAndView getUserById(int userId)
    {
        //根据用户ID，获取用户信息
        com.czy.entity.UserInfo userInfo = userService.getUserById(userId);
 
        if(userInfo==null)
        {
            userInfo = new com.czy.entity.UserInfo();
        }
 
        //返回结果
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfo",userInfo);
        modelAndView.setViewName("/user-info.html");
        return modelAndView;
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("getUserInfo")
    public ModelAndView getUserInfo()
    {
        //根据用户ID，获取用户信息
        com.czy.entity.UserInfo userInfo = userInfoUtil.getUserInfo();

        if(userInfo==null)
        {
            userInfo = new com.czy.entity.UserInfo();
        }

        //返回结果
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfo",userInfo);
        modelAndView.setViewName("/user-info.html");
        return modelAndView;
    }
 
    @ApiOperation(value = "新增用户")
    @ResponseBody
    @PostMapping("insertUser")
    public boolean insertUser()
    {
        //创建新用户
        com.czy.entity.UserInfo userInfo = new com.czy.entity.UserInfo();
        userInfo.setUserName("chenzy");
        userInfo.setPassword("123456");
        userInfo.setAge(32);
        userInfo.setBlogUrl("https://chenzy.com");
        userInfo.setBlogRemark("您好，欢迎访问 chenzy的博客");
 
        //执行新增方法
        userService.insertUser(userInfo);
 
        //返回结果
        return userInfo.getUserId() > 0 ? true : false;
    }
 
    @ApiOperation(value = "修改用户")
    @ResponseBody
    @PutMapping("updateUser")
    public boolean updateUser(int userId, int age)
    {
        com.czy.entity.UserInfo userInfo = new com.czy.entity.UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName("chenzy");
        userInfo.setPassword("123456");
        userInfo.setAge(age);
        userInfo.setBlogUrl("https://chenzy.com");
        userInfo.setBlogRemark("您好，欢迎访问 chenzy的博客");
 
        //执行修改方法
        userService.updateUser(userInfo);
 
        //返回结果
        return true;
    }
 
    @ApiOperation(value = "删除用户")
    @ResponseBody
    @DeleteMapping("deleteUser")
    public boolean deleteUser(int userId)
    {
        //执行新增方法
        int result = userService.deleteUser(userId);
 
        //返回结果
        return result > 0 ? true : false;
    }
}