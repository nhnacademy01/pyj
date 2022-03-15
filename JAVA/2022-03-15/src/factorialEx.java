import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class factorialEx {
    public static void main(String[] args) {
        BigInteger big = new BigInteger("0");
//        Factorial(30);

//        BigInteger result = facto(BigInteger.valueOf(30));

//        BigDecimalEx();

        DecimalFormat();
    }

//    static BigInteger Factorial(int num){
//        int count = 0;
//        while(count < num){
//            if(num == 0){
//                return big("1");
//            }
//            Factorial(count);
//            count += 1;
//        }
//        return big;
//    }

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
