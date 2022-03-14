package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Bank {
    Random random = new Random();
    static Account account = new Account();
    static List<Account> accounts = new ArrayList<>();

    private final double[] interestRateArr = new double[]{1.1, 2.2, 3.3, 4.4, 5.5};
    static final int BASIC_DEPOSIT_MONEY = 1000;

    List<Account> openAccount(Customer customer, Money initMoney) { //계좌 개설
        try {
            if (initMoney.getAmount() < 0) {
                throw new initMoneyException("(-) 금액으로 계좌 개설이 불가능합니다.");
            }
            if (initMoney.getCurrency() == Money.Currency.YEN) {
                throw new initMoneyException("엔화는 계좌 개설이 불가능합니다.");
            }

        } catch (initMoneyException cause) {
            return null;
        }

        int index = random.nextInt(5);
        accounts.add(new Account(customer, initMoney, (float) interestRateArr[index]));
        return accounts;
    }

    public void showAccountsAll() {
        for (Account account : accounts) {
            try {
                System.out.println(account);
            } catch (NullPointerException cause) {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("김가네"));
        customerList.add(new Customer("이가네"));
        customerList.add(new Customer("박가네"));
        customerList.add(new Customer("최가네"));
        customerList.add(new Customer("양가네"));

        List<Money> moneyList = new ArrayList<>();
        moneyList.add(new Money(0, Money.Currency.WON));
        moneyList.add(new Money(2000, Money.Currency.DOLLAR));
        moneyList.add(new Money(3000, Money.Currency.WON));
        moneyList.add(new Money(-4000, Money.Currency.DOLLAR));
        moneyList.add(new Money(5000, Money.Currency.YEN));

        // 1. 계좌 5개 만들기
        System.out.println("---------------------------");
        System.out.println("5개의 계좌를 개설합니다.");
        System.out.println("---------------------------");
        for (int i = 0; i < 5; i++) {
            bank.openAccount(customerList.get(i), moneyList.get(i));
        }
        bank.showAccountsAll();

        // 입금하기
        System.out.println("---------------------------");
        for (Account account : accounts) {
            int amount = (bank.random.nextInt(10) + 1) * BASIC_DEPOSIT_MONEY;
            try {
                System.out.println(amount + " 입금합니다.");
                account.setBalance(account.deposit(new Money(amount, account.getBalance().getCurrency())));
            } catch (NullPointerException cause) {
                continue;
            }
        }
        System.out.println("---------------------------");
        bank.showAccountsAll();

        // 출금하기
        System.out.println("---------------------------");
        for (Account account : accounts) {
            int amount = (bank.random.nextInt(account.getBalance().getAmount()/1000) + 1) * BASIC_DEPOSIT_MONEY;
            try {
                System.out.println(amount + " 출금합니다.");
                account.setBalance(account.withdrawal(new Money(amount, account.getBalance().getCurrency())));
            } catch (NullPointerException cause){
                continue;
            }
        }
        System.out.println("---------------------------");
        bank.showAccountsAll();

        // 이자지급 (은행의 모든 계좌를 순회하며 계좌의 이율 만큼 이자를 지급한다)
        // TODO 이자지급 이상함
        System.out.println("---------------------------");
        System.out.println("이자를 지급합니다.");
        System.out.println("---------------------------");
        for (Account account : accounts) {
            try {
                account.setBalance(account.payInterest((account)));
            } catch (NullPointerException cause) {
                continue;
            }
        }
        bank.showAccountsAll();

        // 모든 계좌 출력해보기
        System.out.println("---------------------------");
        System.out.println("Bank의 모든 계좌를 보여드릴게요");
        System.out.println("---------------------------");
        bank.showAccountsAll();
    }
}