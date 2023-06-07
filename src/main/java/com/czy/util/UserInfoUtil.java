package com.czy.util;

import com.czy.entity.UserInfo;

/**
 * 用户信息业务逻辑类
 * @author chenzy
 **/
public class UserInfoUtil {
    private UserInfo userInfo;

    public UserInfoUtil() {

    }

    public UserInfoUtil(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}