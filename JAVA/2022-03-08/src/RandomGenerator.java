import java.util.Random;

public class RandomGenerator {
    public static void main(String[] args) {
        Random random = new Random();
        int result = random.nextInt();
        System.out.println("Random number: " + result);

        for (int i = 0; i < 20; i++) {
            int result10 = random.nextInt(10) + 1; // 1 ~ 10 까지 나옴
            System.out.println("Random number(1~10): " + result10);
        }
    }
}
