package com.huaibei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author xiaolong
 * @date 2024/5/8
 */
@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void  sendSimpleMail(String to,String from,String subject,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }
}
