package bank;

import java.math.BigDecimal;

public class Account {
    private Customer customer;
    private Money balance; // 금액
    private float interestRate; //이율

    public Account() {
    }

    public Account(Customer customer, Money balance, float interestRate) {
        this.customer = customer;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    // 입금
    public Money deposit(Money amount) {
        if (amount.getAmount() < 0) {
            throw new depositAmountException("금액이 잘못되었습니다.");
        }
        balance.setAmount((balance.getAmount() + amount.getAmount()));
        return this.balance;
    }

    // 출금
    public Money withdrawal(Money amount) {
        if (amount.getAmount() < 0) {
            throw new withdrawalAmountException("금액이 잘못되었습니다.");
        }
        balance.setAmount(balance.getAmount() - amount.getAmount());
        return this.balance;
    }

    // 이자 지급
    Money payInterest(Account account) {
        int interest = cacluateInterest(account); // 이자
        balance.setAmount(account.getBalance().getAmount() + interest);
        return this.balance;
    }

    private int cacluateInterest(Account account) { // 이자 계산
        return (int) (account.getBalance().getAmount() * (account.getInterestRate())*0.01);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Money getBalance() {
        return balance;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "customer=" + customer +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }
}
