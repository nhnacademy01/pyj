public class Gugudan {
    public static void main(String[] args) {
        Gugudan gugu = new Gugudan();
//        gugu.Gugu();
//        gugu.Star();
        gugu.StarX();
    }

    private void Gugu() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %2d%n", i, j, i * j);
            }
            System.out.println("----------------");
        }
    }

    private void Star() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void StarX() {
        // *   *
        // * *
        //  *
        // * *
        //*   *

        int count = 5;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
                for (int k = 0; k < 1; k++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }
}
