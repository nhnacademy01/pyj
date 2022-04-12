package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.User;

public class SmsMessageSender implements MessageSender {
    public SmsMessageSender() {
        System.out.println("==>SmsMessageSender");
    }

    @Override
    public boolean sendMessage(User user, String message) {
        System.out.println("SMS Message Sent to "+user.getPhoneNumber()+" : " + message);
        return true;
    }

    public void init() {
        System.out.println("init method called in SmsMessageSender");
    }
}
