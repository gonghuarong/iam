package com.sso.controller;

import com.core.response.IamResponse;
import com.sso.dto.UserDto;
import com.sso.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/api/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public IamResponse<List<UserDto>> getUsers(){
        logger.info("查询所有用户信息");
        List<UserDto> users = userService.getUsers();
        return IamResponse.success(users);
    }
}
