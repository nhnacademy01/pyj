package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.annotation.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


public class MessageSenderService {
    private MessageSender messageSender;
    // 생성자로 받으려고 하는데 이 때에는 final을 써줘야한다
    // 왜냐면 생성자 받으면 끝이니까


    @Autowired
    public MessageSenderService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

//    @Autowired
//    public MessageSenderService(@SMS MessageSender messageSender) {
//        this.messageSender = messageSender;
//    }

    public void doSendMessage(User user, String message) {
        messageSender.sendMessage(user, message);
    }

//    public void setMessageSender(MessageSender messageSender){
//        this.messageSender = messageSender;
//    }

    public void setSmsMessageSender(MessageSender messageSender){
        this.messageSender = messageSender;
    }
}
