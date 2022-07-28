package com.core.exception;

import com.core.en.IamHttpEnum;
import com.core.response.IamResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component
@Slf4j
public class IamExceptionHandler {

    @ExceptionHandler(value = IamException.class)
    public IamResponse businessException(IamException e) {
        log.error("reqId：{}，业务异常：{}", MDC.get("reqId"), e.getDesc());
        MDC.clear();
        return IamResponse.failed(e.getCode(), e.getDesc());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public IamResponse runtimeException(RuntimeException e){
        log.error("reqId：{}，系统运行时异常：{}", MDC.get("reqId"), e.getMessage());
        MDC.clear();
        return IamResponse.failed(IamHttpEnum.SYSTEM_FAILED.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public IamResponse exception(Exception e){
        log.error("reqId：{}，未知异常：{}", MDC.get("reqId"), e.getMessage());
        MDC.clear();
        return IamResponse.failed(IamHttpEnum.UNKNOWN_FAILED.getCode(),"未知异常，请联系系统管理员");
    }
}
