package oop.day5;

class SignInUpShell {
    private final AccountService service = new AccountService();

    public static void main(String[] args) {
        SignInUpShell shell = new SignInUpShell();
        shell.start();
    }

    private void start() {
        join();
        login();
    }

    private void login() {
        // Scanner 로 각종 값을 입력 받았다고 가정.
        String userId = "jordan";
        String password = "Passw1rd";

        LoginResult result = service.login(userId, password);
        if (!result.isLogged()) {

            System.out.println("아이디나 비밀번호가 잘못됨.");
        } else {
            System.out.println(result.getName() + "님 로그인 성공!");
        }
    }

    private void join() {
        // Scanner 로 각종 값을 입력 받았다고 가정.
        String userId = "jordan";
        String password = "Passw0rd";
        String name = "JMJ";
        int role = Account.ROLE_ADMIN;
        // TODO JoinRequest 를 만들기 전에 유효성 체크 검사 완료

        service.join(new JoinRequest(userId, password, name, role));
    }
}

public class AccountService {
    private final AccountRepository repository = new AccountRepository();

    // 회원가입
    void join(JoinRequest req) {
        // 회원 가입 요청 객체를 어카운트로 변환
        Account account = req.toAccount();
        // 어카운트를 저장소에 저장
        repository.save(account);
    }

    LoginResult login(String userId, String password) {
        // Nullable
        Account account = repository.findByUserId(userId);
        if (account == null) {
            return LoginResult.fail("로그인 실패!");
        }
        if (!account.matchPassword(password)) {
            account.increaseLoginFailCount();
            return LoginResult.fail("로그인 실패!");
        }
        if (account.isLocked()) {
            return LoginResult.fail("계정이 잠겼습니다.");
        }
        account.initLoginFailCount();
        return LoginResult.success(account);
    }
}

// 어카운트 저장소. 어카운트 저장, 조회 등 영속화 책임을 가진다.
class AccountRepository {
    // {A1, null, null, null, ....}
    Account[] sources = new Account[10];

    public boolean save(Account account) {
        for (int i = 0; i < sources.length; i++) {
            if (sources[i] == null) {
                sources[i] = account;
                // 저장 성공
                return true;
            }
        }
        // 여기로 넘어온 것은 저장 실패
        return false;
    }

    public Account findByUserId(String userId) {
        for (Account source : sources) {
            if (source == null) {
                return null;
            }
            if (source.getUserId().equals(userId)) {
                return source;
            }
        }
        return null;
    }
}

class JoinRequest {
    private final String userId;
    private final String password;
    private final String name;
    private final int role;

//    public JoinRequest(String userId, String password) {
//        this(userId, password, userId);
//    }

//    public JoinRequest(String userId, String password, String name) {
//        this(userId, password, name, Account.ROLE_MEMBER);
//    }

    public JoinRequest(String userId, String password, String name, int role) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    // JoinRequest에서 이 책임 가지는 것은 너무 크다. 별로 좋지 않은 코드.
    public Account toAccount() {
        if (role == Admin.ROLE_ADMIN) {
            return new Admin(userId, password, name);
        } else {
            return new Member(userId, password, name);
        }
    }
}

class LoginResult {
    private final boolean logged;
    private final Account account;
    // 로그인 실패 시 이유
    private final String reason;

    private LoginResult(boolean logged, Account account, String reason) {
        this.logged = logged;
        this.account = account;
        this.reason = reason;
    }
    //
    public static LoginResult fail(String reason) {
        return new LoginResult(false, null, reason);
    }
    //
    public static LoginResult success(Account account) {
        return new LoginResult(true, account, null);
    }

    // 로그인 성공?
    public boolean isLogged() {
        return logged;
    }

    // 로그인 성공한 사용자명
    public String getName() {
        return account.getName();
    }
}

abstract class Account {
    static final int ROLE_ADMIN = 1;    // 관리자 권한
    static final int ROLE_MEMBER = 2;   // 멤버 권한

    private String userId;
    private String password;
    private String name;


    public Account(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return this.name;
    }

    abstract void initLoginFailCount();

    abstract void increaseLoginFailCount();

    abstract boolean isLocked();
}

class Member extends Account {
    private static int MAX_LOGIN_FAIL_COUNT = 4;
    private int loginFailCount;
    public Member(String userId, String password, String name) {
        super(userId, password, name);
    }

    @Override
    void initLoginFailCount() {
        loginFailCount = 0;
    }

    @Override
    void increaseLoginFailCount() {
        loginFailCount++;
    }

    @Override
    boolean isLocked() {
        return loginFailCount >= MAX_LOGIN_FAIL_COUNT;
    }
}

class Admin extends Account {
    public Admin(String userId, String password, String name) {
        super(userId, password, name);
    }

    @Override
    void initLoginFailCount() {
        // Nothing
    }

    @Override
    void increaseLoginFailCount() {
        // Nothing
    }

    @Override
    boolean isLocked() {
        return false;
    }
}















