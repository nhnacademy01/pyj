import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class factorialEx {
    public static void main(String[] args) {
        BigInteger big = new BigInteger("0");
        System.out.println(Factorial(3));
        System.out.println(Factorial2(3));
        System.out.println(Factorial3(3));

//        facto(new BigInteger("30"));

//        BigInteger result = facto(BigInteger.valueOf(30));

//        BigDecimalEx();

//        DecimalFormat();
    }

    static int Factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return Factorial(num-1) * num;
    }

    static int Factorial2(int num){
        while(num == 0){
            return 1;
        }return Factorial2(num-1) * num;
    }

    static int Factorial3(int num){
        // 1 * 2 * 3 ..
        for (int i = num; i > 0; i++) {
            return Factorial3(num-1) * num;
        }
        return 1;
    }

    static BigInteger facto(BigInteger value) {
        if (value.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return value.multiply(facto(value.subtract(BigInteger.ONE)));
    }

    static void BigDecimalEx() {
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.0");

        System.out.printf("%s.equals(%s) = %s%n", bd1, bd2, bd1.equals(bd2));
        System.out.printf("%s.compareTo(%s) = %d%n", bd1, bd2, bd1.compareTo(bd2));
    }

    static void DecimalFormat() {
        double d = 123456.789d;
        System.out.printf("%f > #.##: %s%n", d, new DecimalFormat("#.##").format(d));
        System.out.printf("%f > 0.00: %s%n", d, new DecimalFormat("0.00").format(d));
        System.out.printf("%f > #######.####: %s%n", d, new DecimalFormat("#######.####").format(d));
        System.out.printf("%f > 0000000.0000: %s%n", d, new DecimalFormat("0000000.0000").format(d));
        System.out.printf("%f > #,###.####: %s%n", d, new DecimalFormat("#,###.####").format(d));
        System.out.printf("%f > 0,000.0000: %s%n", d, new DecimalFormat("0,000.0000").format(d));
        System.out.printf("%f > #.#: %s%n", d, new DecimalFormat("#.#").format(d)); // 반올림
        System.out.printf("%f > #: %s%n", d, new DecimalFormat("#").format(d));     // 반올림
    }
}
