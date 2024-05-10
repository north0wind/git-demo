package com.huaibei.service;

import com.huaibei.HelloWorldApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HelloWorldApplication.class)
public class MailServiceTest {

    @Autowired
    MailService mailService;

    @Test
    public void testSendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        mailService.sendSimpleMail("huangyong@crossrainbow.cn"
                ,"lxl960218@qq.com"
                ,"测试邮件内容-LXL"
                ,"测试邮件标题");
    }
}
