package com.nhnacademy.yujinpark.tdd.mockito;

import com.nhnacademy.yujinpark.tdd.mockito.AccountRepository;
import com.nhnacademy.yujinpark.tdd.mockito.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class AccountServiceDummyTest {
    private AccountService service;
    private AccountRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(AccountRepository.class);
        service = new AccountService(repository);
    }

    @Test
    void join_withDummy() {
        DummyAccount account = new DummyAccount();  // dummy
        service.join(account);
    }

    @Test
    void join_withNothingMock() {
        Account account = mock(Account.class);  // dummy
        service.join(account);
    }
}