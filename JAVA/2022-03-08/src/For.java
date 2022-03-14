public class For {
    public static void main(String[] args) {


        For f = new For();

//        f.zeroToTen();
//        f.DaysInMonth12();
//        f.aToZ();
        f.fourToEightArray();
    }

    private void zeroToTen() {
        int n = 10;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.printf("sum 1 to %d = %d\n", n, sum);

    }

    private void DaysInMonth12() {
        DaysInMonth dim = new DaysInMonth();
        for (int i = 1; i <= 12; i++) {
            dim.printDaysInMonth(i);
        }
    }

    private void aToZ() {
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.println((i));
        }
    }

    private void fourToEightArray(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
