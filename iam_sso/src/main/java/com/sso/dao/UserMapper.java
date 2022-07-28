package com.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sso.dto.UserDto;
import com.sso.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserDto> getUsers();
}
