package com.core.aspect;

import com.alibaba.fastjson.JSON;
import com.core.utils.IamUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
@Profile({"dev","test","prod"}) //如果生产环境担心影响性能，将prod去掉即可
public class LogPrintAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.*.controller..*Controller.*(..))")     //采用通用的拦截方式，拦截controller包及子包下的所有以Controller结尾类的所有方法
    public void logPrint(){
        //AOP切入点
    }

    @Before("logPrint()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null){
            throw new NullPointerException("系统打印请求参数异常");
        }
        HttpServletRequest request = attributes.getRequest();
        String reqId = System.currentTimeMillis() + IamUtils.getRandom(5);  //这里使用当前时间戳+5位随机数为请求ID，时间戳便于后续的耗时统计
        MDC.put("reqId", reqId);
        logger.info("reqId：{}，method：{}，URL：{}，request：{}", reqId, request.getMethod(), request.getRequestURI(), getParams(joinPoint));
    }

    @AfterReturning(pointcut = "logPrint()", returning = "response")
    public void afterReturn(JoinPoint joinPoint, Object response) {
        String reqId = MDC.get("reqId");
        logger.info("reqId：{}，time：{}ms，response：{}", reqId, System.currentTimeMillis() - Long.parseLong(reqId.substring(0, reqId.length() - 5)), JSON.toJSONString(response));
        MDC.clear();
    }

    private String getParams(JoinPoint joinPoint) {
        StringBuilder params = new StringBuilder();
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                Object arg = joinPoint.getArgs()[i];
                if ((arg instanceof HttpServletResponse) || (arg instanceof HttpServletRequest)
                        || (arg instanceof MultipartFile) || (arg instanceof MultipartFile[])) {
                    continue;
                }
                try {
                    params.append(JSON.toJSONString(joinPoint.getArgs()[i]));
                } catch (Exception e1) {
                    logger.error(e1.getMessage());
                }
            }
        }
        return params.toString();
    }


}
