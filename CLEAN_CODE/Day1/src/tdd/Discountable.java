package tdd;

@FunctionalInterface
public interface Discountable {
    /**
     * 할인없음
     */
    Discountable NONE = originAmt -> 0;

    long getDiscountAmt(long originAmt);
}
