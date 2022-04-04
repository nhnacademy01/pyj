package day6;

public class AutoBoxingSpeed {
    final static int COUNT = 1000;

    static void speedPrimitiveType() {
        int[] nums = new int[COUNT];    // !
        for (int i = 0; i < COUNT; i++) {
            nums[i] = i;
        }
        long startTime = System.nanoTime();
        int sum = 0;    // !
        for (int i = 0; i < COUNT; i++) {
            sum += nums[i];
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("speedPrimitiveType");
        System.out.printf("%10d%n", estimatedTime);
        System.out.println("---------------------------------");
    }

    private static void speedPrimitiveTypeAndWrapperClass() {
        Integer[] nums = new Integer[COUNT];    // !
        for (int i = 0; i < COUNT; i++) {
            nums[i] = i;
        }
        long startTime = System.nanoTime();
        int sum = 0;    // !
        for (int i = 0; i < COUNT; i++) {
            sum += nums[i];
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("speedPrimitiveTypeAndWrapperClass");
        System.out.printf("%10d%n", estimatedTime);
        System.out.println("---------------------------------");
    }

    private static void speedWrapperClass() {
        Integer[] nums = new Integer[COUNT];    // !
        for (int i = 0; i < COUNT; i++) {
            nums[i] = i;
        }
        long startTime = System.nanoTime();
        Integer sum = 0;    // !
        for (int i = 0; i < COUNT; i++) {
            sum += nums[i];
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("speedWrapperClass");
        System.out.printf("%10d%n", estimatedTime);
        System.out.println("---------------------------------");
    }

    private static void StringToInt() {
        int i1001_10_1 = Integer.parseInt("1001");
        int i1001_10_2 = Integer.valueOf("1001");
        int i1001_10_3 = Integer.parseInt("1001", 10);
        int i1001_10_4 = Integer.valueOf("1001", 10);
        int i1001_2_1 = Integer.parseInt("1001", 2);
        int i1001_2_2 = Integer.valueOf("1001", 2);
        int i1001_8_1 = Integer.parseInt("1001", 8);
        int i1001_8_2 = Integer.valueOf("1001", 8);
        int iAA_16_1 = Integer.parseInt("AA", 16);  // 10(A) * 16 + 10(A)
        int iAA_16_2 = Integer.parseInt("AA", 16);
        int iAA_10 = Integer.parseInt("AA");  // 예외 발생

        System.out.println(i1001_10_1);
        System.out.println(i1001_10_2);
        System.out.println(i1001_10_3);
        System.out.println(i1001_10_4);
        System.out.println(i1001_2_1);
        System.out.println(i1001_2_2);
        System.out.println(i1001_8_1);
        System.out.println(i1001_8_2);
        System.out.println(iAA_16_1);
        System.out.println(iAA_16_2);
        System.out.println(iAA_10);
    }

    public static void main(String[] args) {
//        speedPrimitiveType();
//        speedPrimitiveTypeAndWrapperClass();
//        speedWrapperClass();
//

        StringToInt();
    }
}
