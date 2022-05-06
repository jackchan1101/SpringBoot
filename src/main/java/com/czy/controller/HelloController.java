package com.czy.controller;

import com.czy.config.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chenzy
 * @description:
 * @create 2022/5/5 17:06
 **/
@RestController
public class HelloController {

    @Autowired
    private MyProperties myProperties;

    @RequestMapping("/hello")
    public String hello(){
        return "hello, my name is " + myProperties.getName();
    }

}
