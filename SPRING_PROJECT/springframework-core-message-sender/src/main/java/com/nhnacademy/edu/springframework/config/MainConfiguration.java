package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.messagesender.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSenderService;
import com.nhnacademy.edu.springframework.messagesender.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.annotation.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
@ImportResource("classpath:/xmlconfig/beans.xml")
@EnableAspectJAutoProxy
public class MainConfiguration {
    @Bean
//    @SMS
    public MessageSender smsMessageSender() {
        return new SmsMessageSender();
    }

    @Bean
    public MessageSender emailMessageSender(){
        return new EmailMessageSender();
    }

    @Bean
    @Conditional(SmsMessageSenderCheckCondition.class)
    public MessageSenderService messageSenderService() {
        return new MessageSenderService(emailMessageSender());
        // 여기서 new smsMessageSender()를 하면 bean이 아닌 새 객체가 들어가게 되어서
        // AOP가 끼어들어갈 틈이 없당
    }
}

class SmsMessageSenderCheckCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getBeanFactory().containsBean("smsMessageSender");
    }
}

