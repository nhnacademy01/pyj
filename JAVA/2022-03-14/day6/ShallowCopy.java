package day6;

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        ScMoney amount = new ScMoney(10_000, "WON");
        ScAccount account = new ScAccount(1, amount, "hong");
        ScAccount replica = account.clone(); //shallow copy
        // deep copy 하고싶은데 어떻게 해야할까?
        amount.value = 20_000;

        System.out.println("진짜 객체");
        System.out.println(account);
        System.out.println(account.hashCode()+" + "+ account.getAmount().hashCode());
        System.out.println("복사 객체");
        System.out.println(replica);
        System.out.println(replica.hashCode()+" + "+ replica.getAmount().hashCode());

    }
}
class ScAccount implements Cloneable {
    int type;
    ScMoney amount;
    String depositor;
    public ScAccount(int type, ScMoney amount, String depositor) {
        this.type = type;
        this.amount = amount;
        this.depositor = depositor;
    }

    public ScMoney getAmount() {
        return amount;
    }

    @Override
    protected ScAccount clone() throws CloneNotSupportedException {
        return (ScAccount) super.clone();
    }
    @Override
    public String toString() {
        return "ScAccount{" +
                "type=" + type +
                ", amount=" + amount +
                ", depositor='" + depositor + '\'' +
                '}';
    }
}
class ScMoney {
    long value;
    String currency;
    public ScMoney(long value, String currency) {
        this.value = value;
        this.currency = currency;
    }
    @Override
    public String toString() {
        return "ScMoney{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}