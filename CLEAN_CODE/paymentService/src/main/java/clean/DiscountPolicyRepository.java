package clean;

import java.io.IOException;
import java.util.List;

public interface DiscountPolicyRepository {

    void insert(DiscountPolicy source);

    DiscountPolicy findByCode(String code) throws IOException;

    List<Discountable> findByCodes(List<String> codes);


}
