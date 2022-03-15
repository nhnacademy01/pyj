import java.math.BigInteger;

public class BigIntegerEx {
    public static void main(String[] args) {
        BigInteger num0 = BigInteger.ZERO;  // 기본 상수
        BigInteger num1 = BigInteger.valueOf(Long.MAX_VALUE);   // long
        BigInteger num2 = new BigInteger("1234567890123456789012345");  // String
        BigInteger num3 = new BigInteger(new byte[]{0xf});  // byte[]

        System.out.println("num0: " + num0+" type : "+num0.getClass());
        System.out.println("num1: " + num1+" type : "+num1.getClass());
        System.out.println("num2: " + num2+" type : "+num2.getClass());
        System.out.println("num3: " + num3+" type : "+num3.getClass());
    }
}
