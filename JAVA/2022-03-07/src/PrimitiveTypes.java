public class PrimitiveTypes {
    public static void main(String[] args) {
        PrimitiveTypes types = new PrimitiveTypes();
        types.bytes();

        long total = 20323242340320230L;
        long total2 = 20_323_242_340_320_230L;

    }

    public void bytes(){
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("min byte = " + minByte);
        System.out.println("max byte = " + maxByte);
        byte minByteMinus1 = (byte)(minByte - 1);
        byte maxBytePlus1 = (byte)(maxByte + 1);
        System.out.println("min byte - 1 = "+ minByteMinus1);
        System.out.println("max byte + 1 = "+maxBytePlus1);
        // 오버플로우에 대해서 배웠다
    }
}
