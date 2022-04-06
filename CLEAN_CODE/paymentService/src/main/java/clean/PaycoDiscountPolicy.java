package clean;

public class PaycoDiscountPolicy implements Discountable {
    @Override
    public long getDiscountAmt(long originAmt) {
        return (long) (originAmt * 0.1);
    }
}
