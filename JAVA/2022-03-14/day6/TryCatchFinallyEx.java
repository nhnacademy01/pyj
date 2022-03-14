package day6;

import java.io.File;
import java.util.Scanner;

public class TryCatchFinallyEx {
    public static void main(String[] args) {
        File file = new File("C:\\Temp\\SomeFile.txt");
        Scanner scanner = new Scanner(System.in);

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception cause) {
            System.err.println("스캔 실패: " + cause.toString());
            cause.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }


    }
}
