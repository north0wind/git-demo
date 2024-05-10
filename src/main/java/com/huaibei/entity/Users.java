package com.huaibei.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "com.esp.helloworld.entity.users")
public class Users {
    @Schema(description = "姓名")
    private String name;
    @Schema(description = "性别")
    private String gender;
    @Schema(description = "年龄")
    private Integer age;
    @Schema(description = "金额")
    private Double money;
    @Schema(description = "生日")
    private Date birth;
}
