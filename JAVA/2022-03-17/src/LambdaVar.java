public class LambdaVar {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.test(5);
    }
}

@FunctionalInterface
interface Executable {
    void execute();
}

class Outer {
    int val = 1;
    class Inner { // 중첩 클래스 (정적 중첩 클래스가 아니기 때문에 inner가 바깥쪽거를 접속 가능)
        int val = 2;
        void test(/*final*/ int i) {
            final int val = 3;  // final 을 지우면 어떻게 될까?
//            i = 4;    // 재할당하면 어떻게 될까?
            Executable f = () -> { // 람다
                System.out.println("i(parameter) : " + i);
                System.out.println("val(local - var) : " + val);
                System.out.println("this.val(instance var) : " + this.val);
                // 여기 있는 val은 final이 아닌데 접근이 되고잇다
                // 왜그럴까?
                // 여기 있는 val이 실질적 final이기 때문에
                // i는 재할당 안했음. 실질적 final로 인지중 (나머지도 마찬가지)
                // 만약에 i = 4; 로 재할당 하게 되면 실질적 final이 깨지기 때문에 컴파일 오류
                // 람다에서는 실질적 final만 사용 가능하다
                System.out.println("Outer.this.val(outer instance var) : " + Outer.this.val);
            };
            f.execute();
        }
    }
}