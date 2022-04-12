package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        User user = new User("aa@nhnacademy.com", "010-1234-1234");
//        sendSmsMessage(user, "sms 메세징");
//        sendEmailMessage(user, "email 메세징");

        // 자바의 다형성 이용
//        SmsMessageSender smsMessageSender = new SmsMessageSender();
//        smsMessageSender.sendMessage(user, "하이");
//        EmailMessageSender emailMessageSender = new EmailMessageSender();
//        emailMessageSender.sendMessage(user, "바이");

        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")){
//            MessageSender smsMessageSender1 = context.getBean("smsMessageSender", MessageSender.class);
//            MessageSender smsMessageSender2 = context.getBean("smsMessageSender", MessageSender.class);
//            context.getBean("smsMessageSender", MessageSender.class).sendMessage(user, "오 구현체 없이도 만들수도 있군요?");

            // beans 실습
//            smsMessageSender.sendMessage(user, "이잉 빈즈");
//            emailMessageSender.sendMessage(user, "빈츠먹고싶다");

//            // beans의 scope 실습
//            context.getBean("smsMessageSender", MessageSender.class).sendMessage(user, "1");
//            context.getBean("smsMessageSender", MessageSender.class).sendMessage(user, "2");
//            context.getBean("emailMessageSender", MessageSender.class).sendMessage(user, "3");
//            context.getBean("emailMessageSender", MessageSender.class).sendMessage(user, "4");
//            // beans 에서 singletone은 application context가 올라갈 때 생성자를 먼저 만들어준다
//            // 만약에 singleton으로 getBean 하기 직전에 생성자를 만들고 싶으면 xml에 lazy-init="true"로 적으면 된다
//            // 그러면 getBean을 하기 직전에 생성자를 만들어준다(application context가 실행될 때가 아니라)

            context.getBean("messageSenderService", MessageSenderService.class).doSendMessage(user, "hi");
            // dependency를 최소화 하기 위해서는 구현체.class 말고 interface.class가 더 낫다
        }
    }

    static void sendSmsMessage(User user, String message){
        System.out.println("SMS Message Sent to "+user.getPhoneNumber() + " : "+ message);
    }

    static void sendEmailMessage(User user, String message){
        System.out.println("Email Message Sent to "+user.getEmail() + " : "+ message);
    }


}
