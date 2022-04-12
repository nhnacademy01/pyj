package com.nhnacademy.edu.springframework.messagesender;

public class EmailMessageSender
    implements MessageSender {

    public EmailMessageSender() {
        System.out.println("EmailMessageSender 생성");
    }

    public void destroy(){
        System.out.println("Destro method called in EmailMesssageSender");
    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("Email send "+user.getPhoneNumber() + " : " + message);
    }
}
