package com.core.aspect;

import java.lang.annotation.*;

/**
 * 请求参数和响应参数日志打印注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LogPrint {
    String description() default "";
}
