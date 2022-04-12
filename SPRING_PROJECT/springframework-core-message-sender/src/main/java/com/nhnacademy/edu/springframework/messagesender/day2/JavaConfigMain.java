package com.nhnacademy.edu.springframework.messagesender.day2;

import com.nhnacademy.edu.springframework.messagesender.MessageSenderService;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class JavaConfigMain {
    @Bean
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            "com.nhnacademy.edu.springframework")
        ) {
//            context.getBean("messageSenderService");
//
//            context.getBean("messageSenderService", MessageSenderService.class)
//                .doSendMessage(new User("aaa", "010"), "hi");

            context.getBean("messageSenderService", MessageSenderService.class)
                .doSendMessage(new User("bbb", "123"), "bye");

        }

    }
}
