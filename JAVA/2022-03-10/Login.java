import java.awt.*;
import java.util.Scanner;

class User {
    String id;
    String pwd;
    String pwdCheck;
    String name;

    public User() {
    }

    public User(String id, String pwd, String pwdCheck, String name) {
        this.id = id;
        this.pwd = pwd;
        this.pwdCheck = pwdCheck;
        this.name = name;
    }
}

class Program {
    Scanner scanner = new Scanner(System.in);
    String[][] userArr = new String[50][5];
    User user = new User();
    int count = 0;
    int tryCount = 0;


    public void menu(String[][] userArr) {
        String[][] copyUserArr = new String[50][5];
        copyUserArr = userArr;
        System.out.println("nhn academy 에 오신 것을 환영합니다. 아래에서 메뉴를 선택하세요.");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("0. 종료");
        System.out.print("> ");
        int selectOne = scanner.nextInt();

        if (selectOne == 1) {
            copyUserArr = join(copyUserArr);
        } else if (selectOne == 2) {
            login(copyUserArr, tryCount);
        } else if (selectOne == 0) {
            quit();
        } else {
            System.out.println("잘못된 메뉴입니다.");
        }

    }

    public String[][] join(String[][] userArr) {
        System.out.println("회원가입을 해주세요.");

        System.out.println("아이디 > ");
        String id = scanner.next();

        System.out.println("비밀번호 > ");
        String pwd = scanner.next();

        System.out.println("비밀번호 재입력 > ");
        String pwdCheck = scanner.next();

        System.out.println("이름 > ");
        String name = scanner.next();

        boolean isStore = checkMethods(userArr, id, pwd, pwdCheck, name);

        if (isStore) {
            userArr[count][0] = Integer.toString(count);
            userArr[count][1] = id;
            userArr[count][2] = pwd;
            userArr[count][3] = pwdCheck;
            userArr[count][4] = name;
            count += 1;
            System.out.println("회원가입에 성공했습니다. 이전 메뉴로 돌아갑니다.");
            menu(userArr);
        } else {
            System.out.println("회원가입에 실패했습니다.");
        }
        return userArr;
    }

    public int login(String[][] userArr, int tryCount) {
        System.out.println("로그인 해주세요");
        System.out.println("아이디 > ");
        user.id = scanner.next();
        System.out.println("비밀번호 >");
        user.pwd = scanner.next();

        for (int i = 0; i < userArr.length; i++) {
            if (userArr[i][1].equals(user.id) && userArr[i][2].equals(user.pwd)) {
                loginSuccess(userArr, i);
                return 0;
            } else {
                if (tryCount < 3) {
                    loginFail(tryCount);
                } else {
                    System.out.println("해당 계정은 잠겼습니다.");
                    menu(userArr);

                }

            }
        }
        return 0;
    }

    public void quit() {
        System.out.println("종료합니다");
    }

    public void initializeUserArr(String[][] userArr) {
        for (int i = 0; i < userArr.length; i++) {
            for (int j = 0; j < userArr[i].length; j++) {
                userArr[i][j] = "";
            }
        }
    }

    // null 이면 true (잘못된거)
    public boolean isNull(String id, String pwd, String pwdCheck, String name) {
        if (id.isEmpty() || pwd.isEmpty() || pwdCheck.isEmpty() || name.isEmpty()) {
            return false;
        }
        System.out.println("값을 입력하세요");
        return true;
    }

    // 같으면 true (잘못된거)
    public boolean isSamePwd(String pwd, String pwdCheck) {
        if (!pwd.equals(pwdCheck)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return true;
        }
        return false;
    }

    // 중복이면 true (잘못된거)
    public boolean isDuplicatedId(String[][] userArr, String id) {
        for (int i = 0; i < 50; i++) {
            if (userArr[i][1].equals(id)) {
                System.out.println("아이디 중복입니다");
                return true;
            }
        }
        return false;
    }

    public void loginSuccess(String[][] userArr, int index) {
        System.out.println("[" + userArr[index][4] + "]님 환영합니다.");
    }

    public void loginFail(int tryCount) {
        System.out.println("아이디 혹은 비밀번호가 틀렸습니다. (다시 로그인 해주세요)");
        login(userArr, tryCount + 1);
    }

    // 여지껏 true 잘못된거
    // 회원가입 검사 (true: 제대로 입력함  false: 제대로 입력 x)
    public boolean checkMethods(String[][] userArr, String id, String pwd, String pwdCheck, String name) {
        boolean flag = false;

        flag = isNull(id, pwd, pwdCheck, name);
        flag = isSamePwd(pwd, pwdCheck);
        flag = isDuplicatedId(userArr, id);

        if (!flag) { // 문제없다
            return true;
        }
        return false; // 문제가 있다
    }

}

class LoginMain {
    public static void main(String[] args) {
        Program program = new Program();
        String[][] userArr = new String[50][5];
        program.initializeUserArr(userArr);
        program.menu(userArr);
    }
}
