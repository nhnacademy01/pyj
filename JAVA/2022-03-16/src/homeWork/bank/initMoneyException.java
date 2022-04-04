package bank;

public class initMoneyException extends IllegalArgumentException {

    public initMoneyException(String cause) {
        System.out.println(cause);
    }
}
