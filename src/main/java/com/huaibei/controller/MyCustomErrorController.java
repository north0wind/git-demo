package com.huaibei.controller;

import com.huaibei.exception.CustomException;
import com.huaibei.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
@ControllerAdvice
public class MyCustomErrorController {

    // @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    // @ResponseBody
    // public String handleException(Exception e) {
    //     return "错误已经处理:%s".formatted(e.getMessage());
    // }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> handleCustomException(CustomException ex){
        ApiResponse response = new ApiResponse();
        response.setSuccess(false);
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
