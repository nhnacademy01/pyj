package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.annotation.Sms;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSendService {
    private MessageSender messageSender;

//    @Autowired
//    public void setMessageSender(@Sms MessageSender messageSender) {
//        this.messageSender = messageSender;
//    }

    //@Autowired
    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public boolean doSendMessage(User user, String message) {
        return messageSender.sendMessage(user, message);
    }
}
