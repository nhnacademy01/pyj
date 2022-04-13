package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.annotation.Dooray;
import com.nhnacademy.edu.springframework.annotation.Sms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class MessageSendService {

    private MessageSender messageSender;

//    public void setMessageSender(@Sms MessageSender messageSender) {
//        this.messageSender = messageSender;
//    }

    //    public MessageSendService(){
//
//    }
//
    @Autowired
    public MessageSendService(@Dooray MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public boolean doSendMessage(User user, String message) {
        return messageSender.sendMessage(user, message);
    }
}
