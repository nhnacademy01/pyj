package oop.sign_up;

import java.util.Scanner;

public class SignUpInShell {
    Scanner scanner = new Scanner(System.in);

    Account[] members = new Account[10];

    public void menu(int memberCount, int loginCount) {
        System.out.println("nhn academy 에 오신 것을 환영합니다. 아래에서 메뉴를 선택하세요.");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("0. 종료");
        System.out.print("> ");
        String str = scanner.nextLine();
        int choiceNum = Integer.parseInt(str);

        switch (choiceNum) {
            case 1:
                //회원가입
                join(members, memberCount, loginCount);
                break;
            case 2:
                // 로그인
                while (loginCount < 4) {
                    loginCount = login(members, memberCount, loginCount);
                }
                break;
            case 0:
                System.out.println("프로그램을 종료합니다.");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }

    }

    public int join(Account[] members, int memberCount, int loginCount) {
        boolean[] flagArr = {true, true, true};
        members = initializeMembers(members, 10);

        System.out.println("회원가입을 해주세요.");

        System.out.println("아이디 > ");
        String id = scanner.nextLine();
        flagArr[0] = isDuplicated(members, id, 2);

        System.out.println("비밀번호 > ");
        String pwd = scanner.nextLine();
        System.out.println("비밀번호 재입력 > ");
        String pwdCheck = scanner.nextLine();
        flagArr[1] = isNotMatch(pwd, pwdCheck);

        System.out.println("이름 > ");
        String name = scanner.nextLine();

        System.out.println("권한(1: 관리자, 2: 일반) > ");
        String grant = scanner.nextLine();

        flagArr[2] = isNull(id, pwd, name, grant);

        for (int i = 0; i < flagArr.length; i++) {
            if (flagArr[i]) {
                String cause = findCause(i);
                System.out.println(cause + " 때문에 회원 가입에 실패했습니다.");
                return 0;
            } else {
                continue;
            }
        }
        members[memberCount] = registerMember(id, pwd, name, grant);
        if (members[memberCount] != null) {
            System.out.println("회원 가입에 성공했습니다. 이전 메뉴로 돌아갑니다.");
            memberCount += 1;
            menu(memberCount, loginCount);
        }
        return 0;
    }

    public String findCause(int i) {
        String cause = "";
        if (i == 0) {
            cause += "아이디 중복";
        } else if (i == 1) {
            cause += "비밀번호 불일치";
        } else if (i == 2) {
            cause += "값을 입력하지 않았기";
        }
        return cause;
    }

    // 입력 안함 체크
    public boolean isNull(String id, String pwd, String name, String grant) {
        if (id.equals("") || pwd.equals("") || name.equals("") || grant.equals("")) {
            return true; // 공백이다
        }
        return false; // 공백이 아니다
    }

    // 비번 안 맞음 체크
    public boolean isNotMatch(String pwd, String pwdCheck) {
        if (!pwd.equals(pwdCheck)) {
            return true; // 비번 다르다
        }
        return false; // 비번 같다
    }

    // 아이디 중복
    public boolean isDuplicated(Account[] members, String id, int memberCount) {
        boolean flag = false;
        for (Account account : members) {
            if (account.getId().equals(id)) {

                flag = true; // 중복이다
                break;
            }
        }
        return flag;
    }

    public Account registerMember(String id, String pwd, String name, String grant) {
        Account account = new Account();
        if (grant.equals("1")) {
            account = new Admin(id, pwd, name, grant);
        } else if (grant.equals("2")) {
            account = new User(id, pwd, name, grant);

        } else {
            System.out.println("1번이나 2번을 입력해주세요. ");
            return null;
        }
        return account;
    }

    public int login(Account[] members, int memberCount, int loginCount) {
        System.out.println("로그인 해주세요.");
        System.out.println("아이디 > ");
        String id = scanner.nextLine();
        System.out.println("비밀번호 > ");
        String pwd = scanner.nextLine();

        for (Account account : members) {
            if (account.getId().equals(id) && account.getPwd().equals(pwd)) {
                System.out.println("[" + account.getName() + "] 님 환영합니다.");
                return 10;
            } else {
                if (account.getGrant().equals("2")) {
                    System.out.println("아이디 혹은 비밀번호가 " + (loginCount+1) + "회 틀렸습니다. (다시 로그인 해주세요)");
                    if (loginCount > 3) {
                        System.out.println("해당 계정은 잠겼습니다.");
                    }
                    return loginCount + 1;
                } else {
                    System.out.println("관리자님 아이디 혹은 비밀번호를 제대로 입력해주세요. ");
                    return 0;
                }
            }
        }
        return 10;
    }

    public Account[] initializeMembers(Account[] members, int length) {
        for (int i = 0; i < length; i++) {
            members[i] = new Account();
        }
        return members;
    }

    public static void main(String[] args) {
        SignUpInShell signUpInShell = new SignUpInShell();
        signUpInShell.menu(0, 0);
    }
}


class Account {
    private String id;
    private String pwd;
    private String name;
    private String grant; // 1 관리자 , 2 일반

    public Account() {
        this.id = "";
        this.pwd = "";
        this.name = "";
        this.grant = "";
    }

    public Account(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public Account(String id, String pwd, String name, String grant) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.grant = grant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }
}


class User extends Account {
    private String id;
    private String pwd;
    private String name;
    private String grant; // 1 관리자 , 2 일반

    public User() {

    }

    public User(String id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public User(String id, String pwd, String name, String grant) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.grant = grant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }
}


class Admin extends Account {
    private String id;
    private String pwd;
    private String name;
    private String grant; // 1 관리자 , 2 일반

    public Admin() {

    }

    public Admin(String id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public Admin(String id, String pwd, String name, String grant) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.grant = grant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }
}
