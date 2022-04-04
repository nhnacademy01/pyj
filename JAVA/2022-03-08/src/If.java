import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class If {
    // static 에서 호출하기 때문에
    // static을 붙여줘야한다다
    static boolean isSpring(int month) {
        return month >= 3 && month <= 5;
    }

    private void ifExpressions() {
        int month = 3;
        boolean isSpring = isSpring(month);

        if (isSpring) ;
        if (isSpring) System.out.println("It's warm");
        if (isSpring) {
            System.out.println("The snow melts");
        }
        if (isSpring) {
            System.out.println("Flowers bloom");
        }
        if (!isSpring) {
            System.out.println("Not spring");
        }
    }

    private void ifExp2() {
        int score = 90;
        int x = 6;
        char ch = 'B';
        String str = "I am Hong";

        if (score >= 90 && score <= 100) {
            System.out.println("A");
        }
        if (score < 0 || score > 100) {
            System.out.println("Not a score");
        }
        if (x % 3 == 0 && x % 2 == 0) {
            System.out.println("3의 배수면서 2의 배수");
        }
        if (ch >= 'A' && ch <= 'Z') {
            System.out.println("알파벳 대문자");
        }
        if (str.equals("I am Hong")) {
            System.out.println("I am Home");
        }
        if (str.startsWith("I am")) {
            System.out.println("I am?");
        }
    }

    private void elseExp() {
        int score = 90;
        if (score >= 0 && score <= 100) {
            System.out.println("It's a score");
        } else {
            System.out.println("Not a score");
        }

        if (score >= 0 && score <= 100) System.out.println("It's a score");
        else System.out.println("Not a score");

        if (score >= 0 && score <= 100) {
            System.out.println("It's a score");
        } else {
            System.out.println("Not a score");
        }
    }

    private void elseIfToTriOperator(){
        int score = 91;

        String result = (score>=90) ? "A" : (score>=80)? "B": "F";

        System.out.println(result);
    }

    public static void main(String[] args) {
        If i = new If();
        i.ifExpressions();

        i.ifExp2();

        i.elseExp();

        i.elseIfToTriOperator();
    }

}

