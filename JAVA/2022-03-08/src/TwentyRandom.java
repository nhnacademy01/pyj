import java.util.Random;
import java.util.Scanner;

public class TwentyRandom {
    public static void main(String[] args) {
        TwentyRandom tr = new TwentyRandom();
        tr.Game();

    }

    private void Game() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randNum = random.nextInt(20) + 1;
        int userNum;

        do {
            System.out.print("숫자를 맞춰주세요. (1~20) ");
            System.out.println(randNum);

            userNum = scanner.nextInt();

            if (userNum < randNum) {
                System.out.println("더 큰 값이에요.");
            } else if (userNum > randNum) {
                System.out.println("더 작은 값이에요. ");
            }

        } while (userNum != randNum);{
            System.out.println(userNum + " 정답입니다.");
        }

    }
}
