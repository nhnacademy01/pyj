package com.nhnacademy.yujinpark.tdd.mockito;

import java.util.Objects;
import org.w3c.dom.xpath.XPathResult;

public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void join(Account account) {
        repository.insert(account);
    }

    public Account getAccount(Long id) {
        return repository.findById(id);
    }

    public Account login(String username, String password) {
        // 1. 로그인을 하려면 username으로 계정을 찾아야한다
        // 2. 계정을 찾았으면 반환하면 된다.

        if (username == null) {
            throw new IllegalArgumentException("username is null");
        }

        Account found = repository.findByUsername(username);

        if(found == null){
            return null;
        }

        if(found.isLock()){
            throw new AccountLockedException(username);
        }

        if (!(found.getUsername().equals(username)) || !(found.getPassword().equals(password))) {
            found.setLoginFailureCount(found.getLoginFailureCount() + 1);
            throw new LoginFailedException("Login failed", username);
        }

        if (!Objects.equals(found.getPassword(), password)) {
            // 비밀번호가 맞지 않을 때
            throw new LoginFailedException(username);
        }

//        if(found == null){
        // found가 아무것도 없을 때
//            return null;
        // null을 리턴하는 것과 nullPointException을 리턴하는 것은 다르다
//        }
//        if (!Objects.equals(found.getPassword(), password)){
        // 비밀번호가 맞지 않을 때
//            throw new LoginFailedException(username);
//        }

        // 총 3가지 테스트 시나리오
        return found;
    }

//    public boolean isPossibleToLogin(int failureCount){
//        boolean result =
//        if(failureCount > 3){
//            return false;
//        }
//    }
}