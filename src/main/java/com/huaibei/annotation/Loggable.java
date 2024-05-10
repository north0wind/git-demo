package com.huaibei.annotation;

/**
 * @author xiaolong
 * @date 2024/5/9
 */

import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.annotation.*;

/**
 * 日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Schema
public @interface Loggable {
}
