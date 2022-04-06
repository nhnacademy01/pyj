package com.nhnacademy.yujinpark.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #99 has been fixed")
// 순간적으로 테스트(여러개)를 비활성화 시키는 것
class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
    }
}

class DisabledTestsDemo {

    @Disabled("Disabled until bug #42 has been resolved")
    // 순간적으로 테스트(하나만) 비활성화 시키는 것
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }
}