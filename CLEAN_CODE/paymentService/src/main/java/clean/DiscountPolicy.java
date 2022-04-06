package clean;

import static java.lang.Math.min;

public class DiscountPolicy implements Discountable {
    private String code;
    private Method method;
    private float rate;
    private long amt;

    private DiscountPolicy(String code, Method method, float rate, long amt) {
        if (rate < 0f) {
            throw new IllegalArgumentException("rate must be positive number");
        }
        if (amt < 0L) {
            throw new IllegalArgumentException("amt must be positive number");
        }
        this.code = code;
        this.method = method;
        this.rate = rate;
        this.amt = amt;
    }

    public static DiscountPolicy rate(String code, float rate) {
        return new DiscountPolicy(code, Method.RATE, rate, 0L);
    }

    public static DiscountPolicy amount(String code, long amount) {
        return new DiscountPolicy(code, Method.AMOUNT, 0f, amount);
    }

    public String getCode() {
        return code;
    }

    public float getRate() {
        return rate;
    }

    public long getAmt() {
        return amt;
    }

    @Override
    public long getDiscountAmt(long productAmt) {
        return method.getDiscountAmt(this, productAmt);
    }

    public enum Method {
        RATE() {
            @Override
            long getDiscountAmt(DiscountPolicy discountPolicy, long productAmt) {
                return (long) (productAmt * discountPolicy.rate);
            }
        },
        AMOUNT() {
            @Override
            long getDiscountAmt(DiscountPolicy discountPolicy, long productAmt) {
                return min(productAmt, discountPolicy.amt);
            }
        };

        abstract long getDiscountAmt(DiscountPolicy discountPolicy, long productAmt);
    }
}
