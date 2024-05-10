package com.huaibei.config;

import com.huaibei.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，并指定拦截规则
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/interceptor/**");
    }
}
