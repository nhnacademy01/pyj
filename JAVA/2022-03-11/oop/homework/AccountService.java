//package oop.homework;
//
//
////# 회원가입 케이스
////##회원가입 성공
////아이디, 비번, 성명
////
////회원가입 실패
////
////회원가입시 관리자, 사용자 구분
////
//// #로그인 케이스
////로그인 성공
////로그인 실패
////아이디 못찾음
////비번 안맞음
////계정 잠김 구현
////멤버는 4번 로그인 실패하면 계정 잠김
////관리자는 안잠김
//
//
//class SignInUpShell {
//    private final AccountService service = new AccountService();
//
//    public static void main(String[] args) {
//        SignInUpShell shell = new SignInUpShell();
//        shell.start();
//    }
//
//    private void start() {
//        join();
//        login();
//    }
//
//    private void join() {
//        // Scanner로 값을 받았다고 가정
//        String userId = "jordan";
//        String password = "Passw0rd";
//        String name = "JMJ";
//        int role = Account.ROLE_ADMIN;
//        // TODO joinRequest를 만들기 전에 유효성 체크 검사 완료
//
//
//        service.join(new JoinRequest(userId, password, name, role)); // new JoinRequest로 추상화 시키는 것 추천
//    }
//
//    private void login() {
//        String userId = "jordan";
//        String password = "Passw0rd";
//
//        LoginResult result = service.login(userId, password);
//
//        if (!result.isLogged()) {
//            System.out.println("아이디나 비빌번호가 잘못된 ");
//        }
//        System.out.println(result.getName() + "님 로그인 성공!");
//
//    }
//}
//
//class LoginResult {
//    private final boolean logged;
//    private final Account account;
//
////    public LoginResult(boolean logged) {
////        this.logged = logged;
////        this.account = null;
////    }
//    // 깨진 클래스
//
//    public LoginResult(boolean logged, Account account) {
//        this.logged = logged;
//        this.account = account;
//    }
//
//    public static LoginResult fail() {
//        return new LoginResult(false, null);
//    }
//
//    // 로그인 성공
//    public boolean isLogged() {
//        return logged;
//    }
//
//    // 로그인 성공한 사용자명
//    public String getName() {
//        return null;
//    }
//}
//
//public class AccountService { // AccountService 는 accountrepository에 의존한다 (accountservice 가 추상화 레벨이 더 높다)
//    private final AccountRepository repository = new AccountRepository(); // final 사용해가지고 중간에 바뀔 일이 없다
//
//    // 회원 가입
//    public void join(JoinRequest req) {
//        // 회원 강비 요청 객체를 어카운트로 변환
//        Account account = req.toAccount();
//        // 어카운트를 저장소에 저장
//        repository.save(account);
//
//    }
//
//    public LoginResult login(String userId, String password) {
//        Account account = repository.findByUserId(userId);
//
//        if (account == null) {
//            return LoginResult.fail(); // static 생성자 메소드
////            return new LoginResult(false);
//        }
//        // 비밀번호 일치
//        if(!account.matchPassword(password)){
//            return new LoginResult(false);
//        }
//        return new LoginResult(true, account);
//    }
//}
//
//// 어카운트 저장소. 어카운트 저장, 조회 등 영속화 책임을 가진다
//class AccountRepository {
//    Account[] sources = new Account[10]; //{null, null, null...}
//
//    public boolean save(Account account) {
//        for (int i = 0; i < sources.length; i++) {
//            if (sources[i] == null) {
//                sources[i] = account;
//                // 저장 성공
//                return true;
//            }
//        }
//        return false;
//        // 여기로 넘어온 것은 저장 실패
//    }
//
//    public Account findByUserId(String userId) {
//        for (Account account : sources) {
//            if (account == null) {
//                return null;
//            }
//            if (account.getUserId().equals(userId)) {
//                return sources;
//            }
//        }
//        return null;
//    }
//}
//
//class JoinRequest {
//    // 아이디, 비빌번호, 성명
//    private final String userId;
//    private final String password;
//    private final String name;
//    private final int role; // 인스턴스 변수에 final을 생성하면 초기화를 해줘야 한다
//
//    // 생성자 오버로딩
////    public JoinRequest(String userId, String password) {
////        this(userId, password, userId);
////    }
//
////    public JoinRequest(String userId, String password, String name) {
////        this(userId, password, name, Account.ROLE_MEMBER);
////    }
//
//    public JoinRequest(String userId, String password, String name, int role) { // alt + insert -> shift로 모두 선택
//        this.userId = userId;
//        this.password = password;
//        this.name = name;
//        this.role = role;
//    }
//
//    public Account toAccount() {
//        // 이것은 좋은 코드는 아니다
//        // 왜냐하면 JoinRequest에서 이 책임 가지는 것은 너무 크다. 별로 좋지 않은 코드.
//        // TODO 좋은 코드로 하려면 어떻게 ?
//        if (role == Admin.ROLE_ADMIN) {
//            return new Account(userId, password, name);
//        } else {
//            return new Member(userId, password, name);
//        }
//    }
//}
//
//class Account {
//    static final int ROLE_ADMIN = 1; // 관리자 권한
//    static final int ROLE_MEMBER = 2; // 멤버 권한
//    // 이런건 원래 enum 을 사용하는게 좋다
//
//    private String userId;
//    private String password;
//    private String name;
//
//    public Account(String userId, String password, String name) {
//        this.userId = userId;
//        this.password = password;
//        this.name = name;
//    }
//
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public boolean matchPassword(String password) {
//        return this.password.equals(password);
//    }
//}
//
//class Member extends Account {
//    public Member(String userId, String password, String name) {
//        super(userId, password, name);
//    }
//}
//
//class Admin extends Account {
//    public Admin(String userId, String password, String name) {
//        super(userId, password, name);
//    }
//}