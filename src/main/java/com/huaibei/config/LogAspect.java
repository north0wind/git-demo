package com.huaibei.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xiaolong
 * @date 2024/5/9
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LogManager.getLogger();

    @Pointcut("execution(* com.huaibei.service..*.*(..))")
    public void logAllServiceMethods(){

    }

    @Pointcut("@annotation(com.huaibei.annotation.Loggable)")
    public void logLoggableAnnotation(){

    }

    @Before("logAllServiceMethods()")
    public void logBeforeAllServiceMethods(JoinPoint joinpoint){
        logBefore(joinpoint);
    }

    @Before("logLoggableAnnotation()")
    public void logBeforeLoggableAnnotation(JoinPoint joinPoint){
        logBefore(joinPoint);
    }

    @After("logLoggableAnnotation()")
    public void logAfterLoggableAnnotation(JoinPoint joinPoint){
        logAfter(joinPoint);
    }

    @After("logAllServiceMethods()")
    public void logAfterAllServiceMethods(JoinPoint joinpoint){
        logAfter(joinpoint);
    }

    private void logBefore(JoinPoint joinPoint){
        logger.info("====== Enter: " + joinPoint.getSignature().getName());
    }
    private void logAfter(JoinPoint joinPoint){
        logger.info("====== Exit: " + joinPoint.getSignature().getName());
    }

}
