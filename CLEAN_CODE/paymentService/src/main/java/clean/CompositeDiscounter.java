package clean;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

public class CompositeDiscounter implements Discountable {
    private final List<Discountable> discountables;

    public CompositeDiscounter(List<Discountable> discountableList) {
        this.discountables = discountableList;
    }

    public CompositeDiscounter(DiscountPolicyRepository repository, String... codes) {
        this.discountables = repository.findByCodes(Arrays.asList(codes));
    }

    @Override
    public long getDiscountAmt(long originAmt) {
        long discountAmt = 0L;
        for (Discountable discountable : discountables) {
            discountAmt += discountable.getDiscountAmt(originAmt);
        }
        return discountAmt;
    }
}
