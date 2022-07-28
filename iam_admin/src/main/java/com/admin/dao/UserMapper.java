package com.admin.dao;

import com.admin.dto.UserDto;
import com.admin.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User>{

    List<UserDto> getUsers();
}
