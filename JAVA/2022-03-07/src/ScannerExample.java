import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자를 입력하세요");
        if (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println("입력한 숫자: " + input);
        }
        System.out.println("문자열을 입력하세요");
        if (scanner.hasNext()) {
            String line = scanner.next();
            System.out.println("입력한 문자열: " + line);


        }
    }
}
