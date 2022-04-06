package com.nhnacademy.yujinpark.tdd.mock;

import com.nhnacademy.yujinpark.tdd.mockito.Account;
import com.nhnacademy.yujinpark.tdd.mockito.AccountRepository;
import com.nhnacademy.yujinpark.tdd.mockito.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AccountServiceMockTest {
    private AccountService service;
    private AccountRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(AccountRepository.class); // 목 객체
        service = new AccountService(repository);
    }

    @Test
    void login() {
        String username = "jordan";
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        Account result = service.login(username, password);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull().isPositive();
        assertThat(result.getUsername()).isEqualTo(username);
        assertThat(result.getPassword()).isEqualTo(password);
        // 일반적으로 assertion 먼저 검증한다
        // 리턴값으로 상태 검증하는 것

        verify(repository).findByUsername(username);    // !! verify(mock) 
        // stubpping과 verify(행위를) 는 세트이다
        // 호출한 다음에 행위를 검증해야하니까
        // 행위는 메소드 검사하는 것
    }

    @Test
    void login_usernameIsNull_throwIllegalArgumentException() {
        String username = null;
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        assertThatIllegalArgumentException().isThrownBy(() -> service.login(username, password))
                                            .withMessageContaining("null");

        verify(repository, never()).findByUsername(any());
        // !! verify never는 호출이 안됐음을 검증하는 메소드
        // never() 호출이 안했기를 검증해 -> 그래서 any()를 넣는 것이 좋다
        // never() - any()
    }


    @DisplayName("한 계정에 대해서 비밀번호를 연속 3번 틀리면 계정이 잠기게 해주세요")
    @Test
    void login_incorrectPassword3Times_lockAccount(){
        String username = "jordan";
        String password = "invalid.password";

        Account account = new Account(username, "valid.password");
        when(repository.findByUsername(username)).thenReturn(account);

        service.login(username, password);
        service.login(username, password);
        service.login(username, password);

        assertThat(account.isLock()).isTrue();

        verify(repository, times(3)).findByUsername(username);
    }

    @DisplayName("계정이 잠기면 로그인할 수 없습니다 ('AccountLockedException' 예외가 발생합니다. )")
    @Test
    void login_ifAccountIsLock_disabledLoginByAccountLockedException(){

    }

    @DisplayName("비밀번호를 2번 틀리고, 3번째에 인증을 성공하면 비밀번호 틀림 패널티 횟수는 0으로 초기화 됩니다.")
    @Test
    void login_ifAccountIsLock_disabledLoginByAccountLockedException(){

    }

    @DisplayName("잠긴 계정을 풀 수 있습니다.(unlock 메서드 제공)")
    @Test
    void login_ifAccountIsLock_disabledLoginByAccountLockedException(){

    }
}