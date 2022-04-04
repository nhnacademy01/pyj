package cleanCode;

public class Discount {

    private final long amount;

    private Discount(long discountAmt) {
        this.amount = discountAmt;
    }

    public long getAmount() {
        return amount;
    }

    public static Discount of(long discountAmt) {
        return new Discount(discountAmt);
    }
}
