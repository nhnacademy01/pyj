package tdd;

public class FancafeDiscountPolicy implements Discountable {
    @Override
    public long getDiscountAmt(long originAmt) {
        return 1_000L;
    }
}
