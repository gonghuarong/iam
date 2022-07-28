package com.core.exception;

import com.core.en.IamHttpEnum;
import lombok.Data;

/**
 * 全局异常
 */
@Data
public class IamException extends RuntimeException {

    private final int code;

    private final String desc;

    public IamException(String desc){
        super(desc);
        this.code = IamHttpEnum.FAILED.getCode();
        this.desc = desc;
    }

    public IamException(int code, String desc) {
        super(desc);
        this.code = code;
        this.desc = desc;
    }
}
