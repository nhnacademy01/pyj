package com.nhnacademy.yujinpark.tdd.mockito;

public class LoginFailedException extends RuntimeException {
    public LoginFailedException() {
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String login_failed, String username) {
        super(username+login_failed);

    }
}
