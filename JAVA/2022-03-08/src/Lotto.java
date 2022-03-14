import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.lotto();
    }

    private void lotto() {
        Random random = new Random();

        int[] lotto = new int[6];

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = random.nextInt(45)+1;

            for (int j = 0; j < i; j++) {
                if(lotto[i] == lotto[j]){
                    return;
                }
            }
        }
    }

}
