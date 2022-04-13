package com.nhnacademy.edu.springframework.service;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.User;
import org.springframework.web.client.RestTemplate;

public class DoorayMessageSender implements MessageSender{
    private static final String url = "https://hook.dooray.com/services/3204376758577275363/3250150833993797493/xT8aVgKvSXKccvQyWk2WtA";
    @Override
    public boolean sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), url)
                .send(DoorayHook.builder()
                        .botName(user.getName())
                        .text(message)
                        .build());
        return true;
    }
}
