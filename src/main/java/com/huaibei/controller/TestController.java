package com.huaibei.controller;

import com.huaibei.annotation.Loggable;
import com.huaibei.common.Result;
import com.huaibei.common.ResultGenerator;
import com.huaibei.exception.CustomException;
import com.huaibei.service.AsyncService;
import com.huaibei.utils.IPUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.logging.Logger;

@RestController
@Tag(name = "测试接口",description = "测试接口")
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = Logger.getLogger(TestInterceptorController.class.getName());

    @Value("${sysUser")
    private String sysUser;
    @Value("${age}")
    private int age;
    @Value("${money}")
    private double money;
    @Value("${birth}")
    private Date birth;
    @Value("${message}")
    private String message;

    @Resource
    AsyncService asyncService;

    @GetMapping
    public Object show(){
        System.out.println(sysUser + "\t" + age + "\t" + money + "\t" + birth);
        System.out.println(birth);
        return "ok";
    }

    @GetMapping("/raise")
    public String raiseException(){
        throw new RuntimeException("我是一个产生异常的Controller方法");
    }

    @GetMapping("/custom_error")
    public String raiseCustomException(){
        throw new CustomException("我是一个自定义异常");
    }

    @GetMapping("/async")
    @Operation(summary = "异步任务")
    public Result async(){
        // asyncService.asyncMethod();
        logger.info("异步方法执行完毕");
        return ResultGenerator.genSuccessResult("异步任务启动成功");
    }

    @GetMapping("/message/{id}")
    @Operation(summary = "获取消息")
    @Parameter(name = "id",description = "用户ID")
    @Loggable
    public String getMessage(@PathVariable String id){
        logger.info("123"+"操作开始，IP：{}".format(IPUtils.getIpAddress()));
        return message;
    }

}
