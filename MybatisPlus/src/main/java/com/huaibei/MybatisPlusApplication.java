package com.huaibei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaolong
 * @date 2024/5/9
 */
@SpringBootApplication
@MapperScan("com.huaibei.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
