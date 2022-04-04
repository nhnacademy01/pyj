import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            System.out.println(input);
            if ("bye".equalsIgnoreCase(input)) {
                break;
            }
        }

    }
}
