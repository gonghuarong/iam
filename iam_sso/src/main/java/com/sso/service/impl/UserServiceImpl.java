package com.sso.service.impl;

import com.sso.dao.UserMapper;
import com.sso.dto.UserDto;
import com.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDto> getUsers() {
        return userMapper.getUsers();
    }
}
