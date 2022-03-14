package day6;

import java.io.File;
import java.util.Scanner;

public class TryWithResource {
    public static void main(String[] args) {
        File file = new File("C:\\Temp\\SomeFile.txt");
        try (Scanner scanner = new Scanner(file)) { // !
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception cause) {
            System.err.println("스캔 실패: " + cause.getMessage());
            cause.printStackTrace();
        }
        // finally는 없지만 scanner.close() 메서드가 호출되요
    }

}
