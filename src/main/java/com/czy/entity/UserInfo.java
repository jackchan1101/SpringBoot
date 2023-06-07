package com.czy.entity;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
 
/**
 * 用户信息实体类
 **/
@Data
public class UserInfo implements Serializable {
    private int userId; //用户编号
    private String userName; //用户姓名

    @JsonIgnore
    private String password; //密码
    private int age; //年龄
    private String blogUrl; //博客地址
    private String blogRemark; //博客信息

}