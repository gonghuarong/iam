package com.sso.service;

import com.sso.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
