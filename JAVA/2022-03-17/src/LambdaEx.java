import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class LambdaEx {
    public static void main(String[] args) {
        LambdaEx l = new LambdaEx();
        l.before();
    }

    private void before() { // 람다식이 없던 시절, 익명클래스
        List<String> names = Arrays.asList("jordan", "coco", "comtin", "manty");
        names.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });
        System.out.println(names);
    }

    private void after() {
        List<String> names = Arrays.asList("jordan", "coco", "comtin", "manty");
        names.replaceAll(s -> s.toUpperCase());
        System.out.println(names);
    }
}
