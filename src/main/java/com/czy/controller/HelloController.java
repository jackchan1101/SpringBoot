package com.czy.controller;

import com.czy.config.MyProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chenzy
 * @description:
 * @create 2022/5/5 17:06
 **/
@Api(tags = "测试")
@RestController
public class HelloController {

    @Autowired
    private MyProperties myProperties;

    @ApiOperation(value = "hello")
    @GetMapping("/hello")
    public String hello(){
        return "hello, my name is " + myProperties.getName() + ", password is " + myProperties.getPassword();
    }

}
