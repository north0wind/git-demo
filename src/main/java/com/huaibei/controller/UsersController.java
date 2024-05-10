package com.huaibei.controller;

import com.huaibei.entity.Users;
import jakarta.annotation.Resource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Resource
    private Users users;

    @Resource
    private Environment environment;

    @GetMapping("/showyaml")
    public Object showYaml(){
        return users;
    }

    @GetMapping("/env")
    public Object showEnv(){
        System.out.println(environment.getProperty("sysUser"));
        System.out.println(environment.getProperty("age"));
        System.out.println(environment.getProperty("money"));
        System.out.println(environment.getProperty("birth"));
        System.out.println(environment.getProperty("com.esp.helloworld.entity.users.name"));
        return "hello";
    }
}
