package tdd;

public class SimpleDiscounterFactory implements DiscounterFactory {
    @Override
    public Discountable getDiscounter(String discountCode) {
        return DiscountPolicy2.valueOf(discountCode);
    }
}
