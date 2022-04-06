package clean;

import clean.DiscountPolicyRepository;
import java.io.IOException;
import java.util.List;

public class JsonDiscountPolicyRepository implements DiscountPolicyRepository {


    @Override
    public void insert(DiscountPolicy source) {

    }

    @Override
    public DiscountPolicy findByCode(String code) throws IOException {
        return null;
    }

    @Override
    public List<Discountable> findByCodes(List<String> codes) {
        return null;
    }
}
