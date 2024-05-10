package com.huaibei.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
@Service
public class ScheduledService {
    private static final Logger logger = LogManager.getLogger();
    // @Scheduled(fixedRate = 1000)
    // public void reportCurrentTime() {
    //     logger.info("现在时间：" + System.currentTimeMillis());
    // }
}
