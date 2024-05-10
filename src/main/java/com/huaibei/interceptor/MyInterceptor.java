package com.huaibei.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.logging.Logger;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
public class MyInterceptor implements HandlerInterceptor {
    private static final Logger logger = Logger.getLogger(MyInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("MyInterceptor preHandle %s".formatted(request.getRequestURI()));
        return true;
    }
}
