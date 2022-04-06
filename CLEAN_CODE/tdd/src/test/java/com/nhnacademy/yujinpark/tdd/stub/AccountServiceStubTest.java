package com.nhnacademy.yujinpark.tdd.stub;

import com.nhnacademy.yujinpark.tdd.mockito.Account;
import com.nhnacademy.yujinpark.tdd.mockito.AccountRepository;
import com.nhnacademy.yujinpark.tdd.mockito.AccountService;
import com.nhnacademy.yujinpark.tdd.mockito.LoginFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class AccountServiceStubTest {
    private AccountService service;
    // sut 는 service
    private AccountRepository repository;
    // doc는 accountRepository 겸 stub

    @BeforeEach
    void setUp() {
        repository = mock(AccountRepository.class);
        service = new AccountService(repository);
    }

    @Test
    void login() {
        String username = "jordan";
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        // TODO: findByUsername 구현
        when(repository.findByUsername(username)).thenReturn(account);
        // 조작했다. 이것이 stubpping 이다
        // 어떤 상황이 일어나는 것을 강제했다 -> 이것이 stubpping

        // TODO: login 구현
        Account result = service.login(username, password);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull().isPositive();
        assertThat(result.getUsername()).isEqualTo(username);
        assertThat(result.getPassword()).isEqualTo(password);
    }

    @Test
    void login_notFound_returnNull() {
        String username = "not.exists";
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(null);
        // sutb 조작당하는 객체들

        Account result = service.login(username, password);

        assertThat(result).isNull();
    }

    @Test
    void login_notMatchedPassword_throwLoginFailedException() {
        String username = "jordan";
        String password = "invalid.password";

        Account account = new Account(username, "valid.password");
        when(repository.findByUsername(username)).thenReturn(account); //when으로 조작한 상황이 Stubbings

        assertThatThrownBy(() -> service.login(username, password))
            .isInstanceOf(LoginFailedException.class)
            .hasMessageContainingAll("Login failed", username); //메세지 안에 이 문장들이 있냐
    }
}