package com.admin.service.impl;

import com.admin.dao.UserMapper;
import com.admin.dto.UserDto;
import com.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDto> getUsers() {
        return userMapper.getUsers();
    }
}
