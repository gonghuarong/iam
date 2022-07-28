package com.core.en;

/**
 * IAM HTTP状态枚举
 */
public enum IamHttpEnum {

    SUCCESS(2000, "请求成功"),
    FAILED(2001,"请求失败"),
    SYSTEM_FAILED(5000,"系统异常"),
    UNKNOWN_FAILED(9999,"未知错误");

    private int code;
    private String message;

    IamHttpEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
