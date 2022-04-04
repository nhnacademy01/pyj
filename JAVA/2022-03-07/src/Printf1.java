public class Printf1 {
    public static void main(String[] args) {
        byte b = 10;
        short s = 20;
        char c = 'C';
        int i = 55;
        long l = Long.MAX_VALUE;
        int hex = 0xFFFF_FFFF;
        int oct = 010;
        int binary = 0b1001;

        System.out.printf("b = %d%n", b);
        System.out.printf("s = %d%n", s);
        System.out.printf("c = %c, %d%n", c, (int)c);
        System.out.printf("i = [%5d]%n", i);
        System.out.printf("i = [%-5d]%n", i);
        System.out.printf("i = [%05d]%n", i);
        System.out.printf("hex = %x%n", hex);
        System.out.printf("hex = %#x%n", hex);
        System.out.printf("hex = %#X%n", hex);
        System.out.printf("oct = %#o, %d%n", oct, oct);
        System.out.printf("binary = %s, %d%n", Integer.toBinaryString(binary), binary);

    }
}
