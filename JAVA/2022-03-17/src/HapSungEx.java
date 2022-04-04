import java.util.function.Function;
import java.util.function.UnaryOperator;

public class HapSungEx {
    public static void main(String[] args) {
        HapSungEx hapSungEx = new HapSungEx();
        hapSungEx.hapSungFunc();


    }

    private void hapSungFunc() {
        String str = "hello";
        UnaryOperator<String> f2 = s -> s.toUpperCase();
        Function<String, char[]> f3 = s -> s.toCharArray();
        Function<char[], Long> f4 = chs -> {
            long sum = 0;
            for (char ch : chs) {
                sum += ch;
            }
            return sum;
        };

//        Function<char[], Long> f4 = chs ->  sumChars(chs);

        Function<String, Long> func = f2.andThen(f3).andThen(f4);
        Long output = func.apply(str);
        System.out.println("output : " + output);

    }

    private long sumChars(char[] chs) {
        long sum = 0;
        for (char ch : chs) {
            sum += ch;
        }
        return sum;
    }

}
