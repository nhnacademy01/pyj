package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class JavaConfigMain {

    private static final Log log = LogFactory.getLog(JavaConfigMain.class);
    @Autowired
    @Bean
    public static void main(String[] args) {
        log.warn("JavaConfigMain STARTING !!! ");

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework")) {
            //context.getBean("messageSendService");


            context.getBean("messageSendService", MessageSendService.class)
                    .doSendMessage(new User("NHN", "", "010" ), "이번 주말 과제는 없습니다");
        }
    }
}
