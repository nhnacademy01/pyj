package clean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapDiscountPolicyRepository implements DiscountPolicyRepository {
    Map<String, DiscountPolicy> source = new HashMap<>();

    @Override
    public void insert(DiscountPolicy policy) {
        source.put(policy.getCode(), policy);
    }

    @Override
    public DiscountPolicy findByCode(String code) {
        return source.get(code);
    }

    @Override
    public List<Discountable> findByCodes(List<String> codes) {
        return codes.stream()
                    .map(this::findByCode)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
    }
}
