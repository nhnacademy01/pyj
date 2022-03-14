import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.next();
            System.out.println(input);
        }
    }
}
