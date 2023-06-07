package com.czy.mapper;

import com.czy.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPermissionMapper {

    List<Permission> findByUserName(String userName);
}
