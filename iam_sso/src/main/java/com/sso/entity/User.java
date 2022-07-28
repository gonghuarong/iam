package com.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 * @TableName t_user
 */
@Data
@TableName("t_user")
public class User implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pass;

    /**
     * 工号
     */
    private String employeeid;

    /**
     * 状态：1正常，0失效
     */
    private String status;

    /**
     * 归属部门ID
     */
    private Integer deptId;

    private static final long serialVersionUID = 1L;
}