package com.czy.service.impl;
 
import com.czy.entity.UserInfo;
import com.czy.mapper.UserMapper;
import com.czy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
 
/**
 * 用户信息业务逻辑类
 * @author chenzy
 **/
//注意：必须对应配置文件ehcache.xml中cache节点的name属性值
//@CacheConfig(cacheNames = "userCache")
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;
 
    //注意：必须对应配置文件ehcache.xml中cache节点的name属性值
    private static final String CACHE_NAME = "userCache";
 
    /**
     * 根据用户ID，获取用户信息
     */
    @Override
    @Cacheable(value = CACHE_NAME, key = "#userId")
    public UserInfo getUserById(int userId)
    {
        return userMapper.getUserById(userId);
    }
 
    /**
     * 新增用户，并获取自增主键
     */
    @Override
    @CachePut(value = CACHE_NAME, key = "#userInfo.userId")
    public UserInfo insertUser(UserInfo userInfo)
    {
        userMapper.insertUser(userInfo);
        return userInfo;
    }
 
    /**
     * 修改用户
     */
    @Override
    @CachePut(value = CACHE_NAME, key = "#userInfo.userId")
    public UserInfo updateUser(UserInfo userInfo)
    {
        userMapper.updateUser(userInfo);
        return userInfo;
    }
 
    /**
     * 删除用户
     */
    @Override
    @CacheEvict(value = CACHE_NAME, key = "#userId")
    public int deleteUser(int userId)
    {
        return userMapper.deleteUser(userId);
    }
}