package bank;

public class withdrawalAmountException extends IllegalArgumentException{
    public withdrawalAmountException(String cause) {
        System.out.println(cause);
    }
}
