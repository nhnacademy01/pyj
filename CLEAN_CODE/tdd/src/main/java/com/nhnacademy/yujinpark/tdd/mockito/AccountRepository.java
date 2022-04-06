package com.nhnacademy.yujinpark.tdd.mockito;

public interface AccountRepository {
    void insert(Account account);

    Account findById(Long id);

    Account findByUsername(String username);
}