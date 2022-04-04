package day6;

class Money {
    long amount;
    String currency;

    /**
     * @param args
     * @throws InvalidMoneyException 음수인 경우
     */


    public Money(long amount, String currency) {
        if (amount < 0L) {   // 돈이 음수가 될 수 있나?
            throw new InvalidMoneyException("Money is not negative. " + amount);
        }
        if (!isSupportedCurrency(currency)) {   // 지원되지 않는 통화의 경우.
            throw new InvalidMoneyException("Not supported currency. " + currency);
        }
        this.amount = amount;
        this.currency = currency;
    }

    private boolean isSupportedCurrency(String currency) {
        return (currency.equals("원") || currency.equals("$"));
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }


    public static void main(String[] args) {

        Money money2 = new Money(-1000, "원");

//        try {
//            Money money1 = new Money(1000, "원");
//            System.out.println("moeny1 : " + money1.toString());
//
////            Money money2 = new Money(-1000, "원");
////            System.out.println("moeny2 : " + money2.toString());
//
//            Money money3 = new Money(1000, "멍멍");
//            System.out.println("moeny3 : " + money3.toString());
//        } catch (IllegalArgumentException cause) {
//            cause.printStackTrace();
//        }
    }
}