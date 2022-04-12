package com.nhnacademy.edu.springframework.messagesender;

interface MessageSender {
    void sendMessage(User user, String message);
}
