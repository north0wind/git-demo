package com.huaibei.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
@Service
public class AsyncService {
    private static final Logger logger = LogManager.getLogger();

    // @Async
    // public void asyncMethod(){
    //     logger.info("asyncMethod start");
    //     try {
    //         Thread.sleep(2000);
    //     } catch (InterruptedException e) {
    //         logger.error(e);
    //     }
    //     logger.info("asyncMethod end");
    // }
}
