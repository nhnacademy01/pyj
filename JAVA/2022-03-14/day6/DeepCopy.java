package day6;

public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        DcMoney amount = new DcMoney(10_000, "WON");
        DcAccount account = new DcAccount(1, amount, "hong");
        DcAccount replica = account.clone();

        amount.value = 20_000;

        System.out.println(account);
        System.out.println(replica);
    }
}
class DcAccount implements Cloneable {
    int type;
    DcMoney amount;
    String depositor;
    public DcAccount(int type, DcMoney amount, String depositor) {
        this.type = type;
        this.amount = amount;
        this.depositor = depositor;
    }
    @Override
    protected DcAccount clone() throws CloneNotSupportedException {
        DcAccount clone = (DcAccount) super.clone();
        clone.amount = this.amount.clone();
        // 이 구문 때문에 Deep copy
        return clone;
    }
    @Override
    public String toString() {
        return "DcAccount{" +
                "type=" + type +
                ", amount=" + amount +
                ", depositor='" + depositor + '\'' +
                '}';
    }
}
class DcMoney {
    long value;
    String currency;
    public DcMoney(long value, String currency) {
        this.value = value;
        this.currency = currency;
    }
    @Override
    protected DcMoney clone() throws CloneNotSupportedException {
        return new DcMoney(this.value, this.currency);  // 복사 생성자
        // new 를 했기 때문에
    }
    @Override
    public String toString() {
        return "DcMoney{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}