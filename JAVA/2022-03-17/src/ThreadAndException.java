public class ThreadAndException {
    public static void main(String[] args) {
        System.out.println("Before call thread");
        new Thread(new ExceptionalRunner()).start();
        new ExceptionalRunner().run();    // 이 주석을 제거하면?
        System.out.println("After call thread");
        // 이것은 메인 스레드이기 때문에 오류가 낫음에도 불구하고 이 줄이 찍힌다
    }
}

class ExceptionalRunner implements Runnable {
    @Override
    public void run() {
        System.out.println("hihihihi");
        throw new RuntimeException("Unknown Exception.");
    }
}