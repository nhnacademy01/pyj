import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

public class Function {
    public static void main(String[] args) {


        Function f = new Function();
//        f.lambdaAndAbstract();

        f.primitiveTypeFunctionalInterface();
    }

    private void lambdaAndAbstract() {
        List<String> list = new ArrayList<>();
        list.add("Welcome");
        list.add("NHN");
        list.add("Academy");
        // Predicate
        list.removeIf(s -> s.equals("NHN")); // 필터한 것임

        // Supplier(RandomNumberGenerator)
        Supplier<Integer> rng = () -> new Random().nextInt(10);

        // Function(UnaryOperator)
        list.replaceAll(s -> s.toLowerCase() + rng.get());

        // Consumer
        list.forEach(s -> {
            System.out.print(s + " ");
        });
    }

    private void primitiveTypeFunctionalInterface() {
        final int max = 100_000_000;

        // IntBinaryOperator
        int sum2 = 0;
        long startTime2 = System.nanoTime();
        IntBinaryOperator funcSum2 = (sum, delta) -> sum + delta;
        for (int i = 0; i < max; i++) {
            sum2 = funcSum2.applyAsInt(sum2, i);
        }
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.printf("sum2: %,15d > %,15d%n", sum2, estimatedTime2);

        // BinaryOperator<Integer>
        Integer sum1 = Integer.valueOf(0);
        BinaryOperator<Integer> funcSum1 = (sum, delta) -> sum + delta;
        long startTime1 = System.nanoTime();
        for (int i = 0; i < max; i++) {
            sum1 = funcSum1.apply(sum1, i);
        }
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.printf("sum1: %,15d > %,15d%n", sum1, estimatedTime1);
    }



}
