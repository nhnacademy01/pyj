package com.nhnacademy.yujinpark.tdd.mockito;

import java.util.HashMap;
import java.util.Map;

public class HashMapAccountRepository  implements AccountRepository {
    Map<Long, Account> source = new HashMap<>();

    @Override
    public void insert(Account account) {
        source.put(account.getId(), account);
    }

    @Override
    public Account findById(Long id) {
        return source.get(id);
    }

    @Override
    public Account findByUsername(String username) {
        return null;
    } // 복잡하니 구현하지 마라
    // 이거 말고 login 구현에 집중할 것이다
}
