public class Money2 {
    long amount = 0L;
    String currency = "WON";
    static int count = 0;

    // 클래스 초기화 블럭
    static {
        System.out.println("클래스 초기화");
        count++;
    }

    // 인스턴스 초기화 블럭
    {
        System.out.println("인스턴스 초기화");
        amount = 10L;
        currency = "DOLLAR";
        count++;
    }

    public Money2() {
        System.out.println("생성자");
        amount = 1L;
        currency = "GOLD";
        count++;
    }

//    public static void main(String[] args) {
//        System.out.println("main 실행");
//        Money2 money2 = new Money2();
//        System.out.printf("money2 = %d %s%n", money2.amount, money2.currency);
//        System.out.printf("calling count = %d%n", count);
//    }

//클래스 초기화 --> 메인 메소드가 있는 곳이 Money2 클래스이기 때문에 클래스 초기화가 가장 먼저 됨
//main 실행
//인스턴스 초기화
//생성자
//money = 1 GOLD
//calling count = 3

}

class Main {
    public static void main(String[] args) {
        System.out.println("main 실행");
        Money2 money2 = new Money2();
        System.out.printf("money2 = %d %s%n", money2.amount, money2.currency);
        System.out.printf("calling count = %d%n", Money2.count);
    }
}