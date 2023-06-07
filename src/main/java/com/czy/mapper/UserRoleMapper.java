package com.czy.mapper;

import com.czy.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    List<Role> findByUserName(String userName);
}
