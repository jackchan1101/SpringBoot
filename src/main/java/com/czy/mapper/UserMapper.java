package com.czy.mapper;
 
import com.czy.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
 
/**
 * 用户信息Mapper动态代理接口
 * @author chenzy
 **/
@Mapper
@Repository
public interface UserMapper {
    /**
     * 根据用户ID，获取用户信息
     */
    @Select("SELECT * FROM tb_user WHERE user_id = #{userId}")
    UserInfo getUserById(int userId);
 
    /**
     * 新增用户，并获取自增主键
     */
    @Insert("INSERT INTO tb_user(user_name,age,blog_url,blog_remark) VALUES(#{userName},#{age},#{blogUrl},#{blogRemark});")
    @Options(useGeneratedKeys = true, keyColumn = "user_id", keyProperty = "userId")
    int insertUser(UserInfo userInfo);
 
    /**
     * 修改用户
     */
    @Update("UPDATE tb_user SET user_name = #{userName} ,age = #{age} ,blog_url = #{blogUrl} ,blog_remark = #{blogRemark} WHERE user_id = #{userId}")
    int updateUser(UserInfo userInfo);
 
    /**
     * 删除用户
     */
    @Delete("DELETE FROM tb_user WHERE user_id = #{userId}")
    int deleteUser(int userId);

    /**
     * 根据用户名，获取用户信息
     */
    @Select("SELECT * FROM tb_user WHERE user_name = #{userName}")
    UserInfo findByUserName(String userName);
}