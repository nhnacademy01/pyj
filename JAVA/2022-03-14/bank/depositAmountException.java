package bank;

public class depositAmountException extends IllegalArgumentException{
    public depositAmountException(String cause) {
        System.out.println(cause);
    }
}
