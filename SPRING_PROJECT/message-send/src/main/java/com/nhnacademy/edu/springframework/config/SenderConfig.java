package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.service.MessageSender;
import com.nhnacademy.edu.springframework.service.SmsMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Bean
    //@Sms
    public MessageSender smsMessageSender() {
        return new SmsMessageSender();
    }
}
