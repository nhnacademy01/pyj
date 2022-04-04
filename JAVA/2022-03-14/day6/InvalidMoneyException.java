package day6;

public class InvalidMoneyException extends IllegalArgumentException {
    //  IllegalArgumentException 을 상속받는게 더 구체적이다
    public InvalidMoneyException(String s) {
        System.out.println(s);
    }
}
