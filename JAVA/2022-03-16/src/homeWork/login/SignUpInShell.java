package login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignUpInShell {
    Scanner scanner = new Scanner(System.in);

    List<Account> members = new ArrayList<Account>();

    /**
     * 고도화 한 부분
     * List<Account> members = new ArrayList<Account>();
     * arr 형태였던 members를 arrayList로 선언하여 이와 관련된 모든 메소드를 수정했습니다.
     * 또한 list에서 넣어야 할 index를 나타내던 memberCount도 ArraLiST로 수정한 이후로 사용하지 않게 되었습니다.
     */
    public void menu(int loginCount) {
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
                join(members, loginCount);
                break;
            case 2:
                // 로그인
                while (loginCount < 4) {
                    loginCount = login(members, loginCount);
                }
                break;
            case 0:
                System.out.println("프로그램을 종료합니다.");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }

    }

    public int join(List<Account> members, int loginCount) {
        boolean[] flagArr = {true, true, true};

        System.out.println("회원가입을 해주세요.");

        System.out.println("아이디 > ");
        String id = scanner.nextLine();
        flagArr[0] = isDuplicated(members, id);

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
        members.add(registerMember(id, pwd, name, grant));
        if (!members.isEmpty()) {
            System.out.println("회원 가입에 성공했습니다. 이전 메뉴로 돌아갑니다.");
            menu(loginCount);
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
    public boolean isDuplicated(List<Account> members, String id) {
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

    public int login(List<Account> members, int loginCount) {
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
                    System.out.println("아이디 혹은 비밀번호가 " + (loginCount + 1) + "회 틀렸습니다. (다시 로그인 해주세요)");
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


    public static void main(String[] args) {
        SignUpInShell signUpInShell = new SignUpInShell();
        signUpInShell.menu(0);
    }
}








