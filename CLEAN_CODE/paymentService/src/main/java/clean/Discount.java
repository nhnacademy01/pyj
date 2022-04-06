package clean;

public class Discount {
    private final long amount;

    private Discount(long discountAmt) {
        this.amount = discountAmt;
    }

    public static Discount of(long discountAmt) {
        return new Discount(discountAmt);
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Discount{" +
               "amount=" + amount +
               '}';
    }
}
