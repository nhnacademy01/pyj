package com.nhnacademy.edu.springframework.messagesender;

public class SmsMessageSender implements MessageSender {

    public SmsMessageSender() {

        System.out.println("SmsMessageSender 생성");
    }

    public void init() {
        System.out.println("SmsMessageSender init() called");
    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS send " + user.getPhoneNumber() + " : " + message);
    }
}
