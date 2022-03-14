import java.util.Scanner;

public class HomeWork2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("input name : ");
            String inputName = scanner.nextLine();
            System.out.print("input email : ");
            String inputEmail = scanner.nextLine();
            System.out.print("input mobile : ");
            String inputMobile = scanner.nextLine();

            if (!inputName.isEmpty() && !inputEmail.isEmpty() && !inputMobile.isEmpty()) {
                System.out.println("OK");

                System.out.printf("%10s:", "name");
                System.out.printf("%10s%n", inputName);
                System.out.printf("%10s:", "email");
                System.out.printf("%10s%n", inputEmail);
                System.out.printf("%10s:", "mobile");
                System.out.printf("%10s%n", inputMobile);
                return;

            } else {
                System.out.println("FAIL");
                System.out.println("name, email, mobile 을 모두 입력하세요");
            }
        }
    }
}
