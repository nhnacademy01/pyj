import java.util.Arrays;

public class SageVerargsEx {
    public static <T> T[] toArray(T... elements) { // ... 은 가변인자 (계속 나열할 수 있는 것)
        return elements; // unsafe! 애초에 varargs의 배열을 그대로 던지면 안됨.
    }
    // toArray로 호출하면 T가 String[]으로 확인됨
    public static <T> T[] broken(T seed) {
        T[] objs = toArray(seed, seed, seed);   // 런타임 시에 정해짐
        System.out.println("objs.class = " + objs.getClass());
        return objs;
    }
    // 감싸져서 string 보다 상위의 object로 확인됨
    public static void main(String[] args) {
        // Safe
        String[] strs = toArray("Welcome", "NHN", "Academy");   // 컴파일 때 String[] 으로 정해짐
        System.out.println(Arrays.toString(strs));
        System.out.println("strs.class = " + strs.getClass());

        // Unsafe
//        String[] forest = broken("Tree"); // ClassCastException
//        Integer[] busy = broken(1);       // ClassCastException
    }
}


