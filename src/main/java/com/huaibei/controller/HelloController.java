package com.huaibei.controller;

import com.huaibei.dto.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://example.com")
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("cors")
//    @CrossOrigin(origins = "http://example.com")
    public String helloCORS(){
        return "Hello CORS!";
    }

    @GetMapping("/user/by/servlet/request")
    public String getUserByIdBindByServletRequest(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        return "Hello" + id;
    }

    @GetMapping("/user/by/path/variable/{id}")
    public String getUserByIdBindByPathVariable(@PathVariable("id") Long id){
        return "Hello " + id;
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        return "Hello " + user.getName();
    }
}