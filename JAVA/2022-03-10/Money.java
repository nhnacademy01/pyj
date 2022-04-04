//import java.util.concurrent.atomic.AtomicLong;
//
//public class Money {
//    AtomicLong amount;
//    String currency;
//
//    public Money(){
//        this(new AtomicLong(0L));
//    }
//
//    public Money(AtomicLong amount){
//        this.amount = amount;
//    }
//
//    public Money(Money original){
//        this.amount = original.amount; // 공유 됨
//        this.amount = new AtomicLong(original.amount.get());
//    }
//
//    void changeAmount(long amount){
//        this.amount.set(amount);
//    }
//
//    void print(){
//        System.out.println("Money(amount : "+amount.get() +")");
//    }
//
//    public static void main(String[] args) {
//        Money m1 = new Money(new AtomicLong(1_000L);
//        Money m2 = new Money(m1);
//        m1.changeAmount(2_000);
//
//        m1.print();
//        m2.print();
//
//    }
//}
