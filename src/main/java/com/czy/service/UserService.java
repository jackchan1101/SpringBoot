package com.czy.service;

import com.czy.entity.UserInfo;

/**
 * @author Chenzy
 * @description:
 * @create 2023/6/6 15:06
 **/
public interface UserService {
    /**
     * 根据用户ID，获取用户信息
     */
    UserInfo getUserById(int userId);

    /**
     * 新增用户，并获取自增主键
     */
    UserInfo insertUser(UserInfo userInfo);

    /**
     * 修改用户
     */
    UserInfo updateUser(UserInfo userInfo);

    /**
     * 删除用户
     */
    int deleteUser(int userId);
}
