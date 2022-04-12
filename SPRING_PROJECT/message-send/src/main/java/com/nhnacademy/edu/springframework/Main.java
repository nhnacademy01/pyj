package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.service.MessageSendService;
import com.nhnacademy.edu.springframework.service.MessageSender;
import com.nhnacademy.edu.springframework.service.SmsMessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user = new User("jibum.jung@nhndooray.com", "010-5586-8797");

//        MessageSender messageSender = new SmsMessageSender();
//        messageSender.sendMessage(user, "Love it!");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
//            MessageSender messageSender = context.getBean("smsMessageSender", MessageSender.class);
//            messageSender.sendMessage(user, "Like it!!");

//            context.getBean("smsMessageSender", MessageSender.class).sendMessage(user, "3");
//            context.getBean("smsMessageSender", MessageSender.class).sendMessage(user, "4");
//
//            context.getBean("emailMessageSender", MessageSender.class).sendMessage(user, "1");
//            context.getBean("emailMessageSender", MessageSender.class).sendMessage(user, "2");

            context.getBean("messageSendService", MessageSendService.class).doSendMessage(user, "5");
        }
    }

}
