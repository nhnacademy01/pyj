package tdd;

import java.util.List;

public interface DiscountPolicyRepository {

    void insert(DiscountPolicy source);

    DiscountPolicy findByCode(String code);

    List<Discountable> findByCodes(List<String> codes);


}
