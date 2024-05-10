package com.huaibei.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class IPUtils {
    public static String getIpAddress(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null){
            return "未知";
        }
        return attributes.getRequest().getRemoteAddr();
    }
}
