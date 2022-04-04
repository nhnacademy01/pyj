package bank;

public class Money {
    private int amount; // 돈
    private Currency currency; // 단위

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int add(Money money) {
        this.amount += money.getAmount();
        return amount;
    }

    public int substract(int balance, int money) {
        return balance - money;
    }

    public enum Currency {
        WON, DOLLAR, YEN
    }

    public int getAmount() {

        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String toString() {
        return amount + " " + currency;
    }
}