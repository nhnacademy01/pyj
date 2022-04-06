package com.nhnacademy.yujinpark.tdd.mockito;

public class AccountLockedException extends RuntimeException {
    public AccountLockedException(String username) {
        super(username + " locked");
    }
}
