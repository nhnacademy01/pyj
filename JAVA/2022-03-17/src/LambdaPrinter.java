public class LambdaPrinter {
    public static void main(String[] args) {
        StringFunction sf = s -> s.toUpperCase(); // 람다식
        StringFunction sf2 = s -> s.toLowerCase(); // 람다식
        StringFunction sf3 = new StringFunction() { // 익명 클래스
            @Override
            public String apply(String input) {
                return input.toLowerCase();
            }
        };
        StringFunction sf4 = new StringFunction() { // 익명 클래스
            @Override
            public String apply(String input) {
                return input.toLowerCase();
            }
        };
        System.out.println(sf);
        System.out.println(sf2);
        System.out.println(sf3); // $1 첫번째 익명 클래스
        System.out.println(sf4); // $2 두번째 익명 클래스
        // sf3, sf4는 각각 다른 타입
    }
}
@FunctionalInterface
interface StringFunction {
    String apply(String input);
}