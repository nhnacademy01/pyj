package com.nhnacademy.edu.springframework.messagesender;

public interface MessageSender {
    void sendMessage(User user, String message);
}
