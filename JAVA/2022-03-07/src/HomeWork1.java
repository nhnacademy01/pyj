import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        // 과제 1번
        Scanner scanner = new Scanner(System.in);
        System.out.print("input : ");
        char input = scanner.next().charAt(0);

        System.out.println(String.format("\\u%04x", (int) input));

        // uni code는 16진수이다
    }
}
