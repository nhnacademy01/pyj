package tdd;

public enum DiscountPolicy2 implements Discountable {
    /* 10% */
    PAYCO(0.1f) {
        @Override
        public long getDiscountAmt(long originAmt) {
            return (long) (originAmt * this.rate);
        }
    },
    /* 15% */
    DAANNAWA(0.15f) {
        @Override
        public long getDiscountAmt(long originAmt) {
            return (long) (originAmt * this.rate);
        }
    },
    /* 1_000 */
    FANCAFE(1_000L) {
        @Override
        public long getDiscountAmt(long originAmt) {
            if (originAmt < this.amt)
                return originAmt;
            return this.amt;
        }
    },
    /* 2_000 */
    NHNACADEMY(2_000L) {
        @Override
        public long getDiscountAmt(long originAmt) {
            if (originAmt < this.amt)
                return originAmt;
            return this.amt;
        }
    }
    ;

    final float rate;
    final long amt;

    DiscountPolicy2(float rate, long amt) {
        this.rate = rate;
        this.amt = amt;
    }

    DiscountPolicy2(float rate) {
        this(rate, 0L);
    }

    DiscountPolicy2(long amt) {
        this(0f, amt);
    }
}
