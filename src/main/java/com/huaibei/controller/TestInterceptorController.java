package com.huaibei.controller;

import com.huaibei.utils.IPUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
@RestController
@Tag(name = "测试拦截器接口",description = "测试拦截器接口")
public class TestInterceptorController {

    @Value("${message}")
    private String message;

    private static final Logger logger = Logger.getLogger(TestInterceptorController.class.getName());

    @GetMapping("/message")
    @Operation(summary = "获取消息")
    @Parameter(name = "id",description = "用户ID")
    public String getMessage(){
        logger.info("操作开始，IP：{}".formatted(IPUtils.getIpAddress()));
        return message;
    }

    @GetMapping("/interceptor/message")
    public String interceptorMessage(){
        logger.info("call interceptor message");
        return message;
    }


}
