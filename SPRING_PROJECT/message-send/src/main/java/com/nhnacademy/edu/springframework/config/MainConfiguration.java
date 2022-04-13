package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.annotation.Sms;
import com.nhnacademy.edu.springframework.service.DoorayMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import com.nhnacademy.edu.springframework.service.MessageSender;
import com.nhnacademy.edu.springframework.service.SmsMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class MainConfiguration {

    @Bean
    public MessageSendService messageSendService(MessageSender messageSender) {
        return new MessageSendService(messageSender);
    }

}
