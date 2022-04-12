package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.User;

public class EmailMessageSender implements MessageSender {
    public EmailMessageSender() {
        System.out.println("==> EmailMessageSender");
    }

    @Override
    public boolean sendMessage(User user, String message) {
        System.out.println("Email Message Sent to "+user.getEmail()+" : " + message);
        return true;
    }

    public void destroy() {
        System.out.println("destroy() called!!");
    }
}
