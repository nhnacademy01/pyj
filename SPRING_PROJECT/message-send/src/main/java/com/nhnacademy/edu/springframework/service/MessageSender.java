package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.User;

public interface MessageSender {
    boolean sendMessage(User user, String message);
}
