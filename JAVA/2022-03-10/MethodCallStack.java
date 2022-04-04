public class MethodCallStack {
    public static void main(String[] args) {
        System.out.println("main 시작");  // (1)
        driveCar();
        System.out.println("main 끝");   // (7)
    }

    static void driveCar() {
        System.out.println("    driveCar 시작");  // (2)
        putOnSeatbelt();
        // (4)
        pushGasPedal();
        System.out.println("    driveCar 끝");   // (6)
    }

    static void putOnSeatbelt() {
        System.out.println("        putOnSeatbelt 호출"); // (3)
    }

    static void pushGasPedal() {
        System.out.println("        pushGasPedal 호출");  // (5)
    }
}