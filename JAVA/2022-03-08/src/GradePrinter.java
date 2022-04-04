import java.util.Scanner;

public class GradePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력하세요: ");
        int score = scanner.nextInt();
        GradePrinter gradePrinter = new GradePrinter();
        gradePrinter.print(score);
    }

    public void print(int score) {
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
