package com.nhnacademy.edu.springframework.messagesender;

public class User {
    private final String email;
    private final String phoneNumber;
    // 한번 만든 이후에 수정이 필요 없으면 final

    public User(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
