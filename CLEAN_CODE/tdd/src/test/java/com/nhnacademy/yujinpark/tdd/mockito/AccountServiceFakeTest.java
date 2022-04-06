package com.nhnacademy.yujinpark.tdd.mockito;

import com.nhnacademy.yujinpark.tdd.mockito.Account;
import com.nhnacademy.yujinpark.tdd.mockito.AccountRepository;
import com.nhnacademy.yujinpark.tdd.mockito.AccountService;
import com.nhnacademy.yujinpark.tdd.mockito.HashMapAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountServiceFakeTest {
    private AccountService service;
    private AccountRepository repository;
    private Account account;

    @BeforeEach
    void setUp() {
        repository = new HashMapAccountRepository();
        service = new AccountService(repository);

        account = new Account("jordan", "P@s5w0rd");
    }

    @Test
    void join() {
        service.join(account);
    }

    @Test
    void findById() {
        service.join(account);
        // TODO: getAccount 메서드를 구현하시오.
        Account result = service.getAccount(account.getId());

        assertThat(result).isNotNull();
        assertThat(result).usingRecursiveComparison().isEqualTo(account);
    }
    @Test
    void findById_butNotFound_returnNull() {
        // TODO: getAccount 메서드를 구현하시오.(2)
        Account result = service.getAccount(Long.MIN_VALUE);

        assertThat(result).isNull();
    }
}