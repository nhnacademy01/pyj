package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.config.MainConfiguration;
import com.nhnacademy.edu.springframework.config.SenderConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MainConfiguration.class, SenderConfig.class})
class MessageSendServiceTest {
//    MessageSender messageSender;
//
//    @BeforeAll
//    void setUp(){
//        messageSender = mock(MessageSender.class);
//    }

    @Autowired
    @InjectMocks
    MessageSendService messageSendService;

    @Mock
    MessageSender messageSender;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(messageSender.sendMessage(any(), any())).thenReturn(false);
    }

    @Test
    void testDoSendMessage() {
        MessageSendService messageSendService = new MessageSendService(messageSender);

        User user = new User("hi","hello@", "010-1234-1234");
        String message = "hello~";

//        ReflectionTestUtils.setField(messageSendService, "messageSender", new MessageSender() {
//            @Override
//            public boolean sendMessage(User user, String message) {
//                System.out.println("i am mock2");
//                return false;
//            }
//        });

        // ???????????? ???????????? ????????? ?????? ????????? ????????? ??? ????????????

        // ???????????? ?????? ??? ?????? ??? ???????????? ??????
//        ReflectionTestUtils.setField(messageSendService, "messageSender",
//                (MessageSender) (user, message) -> {
//                    System.out.println("I am Mock");
//                    return false;
//                });
//        User user = new User("aaa@bbb.com", "010-1234-1234");
//        boolean actual = messageSendService.doSendMessage(user, "hi");
//        assertThat(actual).isFalse();

        // mock ????????? ???????????? ???????????? ??? ??? ?????? ?????????
//        MessageSender mock = mock(MessageSender.class);
//
//        when(mock.sendMessage(user, message)).thenReturn(false);
//
//        ReflectionTestUtils.setField(messageSendService, "messageSender", mock);
//        // name ??? MessageSendService??? ????????? ???????????????
//
//        boolean result = messageSendService.doSendMessage(user, "hello");
//        assertThat(result).isFalse();
//        when(messageSender.sendMessage(user, message)).thenReturn(false);
//        ReflectionTestUtils.setField(messageSendService,"messageSender", messageSender);

        boolean actual = messageSendService.doSendMessage(user, message);
        assertThat(actual).isFalse();
    }

    @Test
    void testUrlResource() throws Exception {
        try (InputStream inputStream = new UrlResource("https://www.manty.co.kr").getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}