package com.nhnacademy.yujinpark.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("♥ 계산기 테스트 ♥")
class CalculatorTest {
    private Calculator calculator = new Calculator();
    @Test
    @DisplayName("➕ 테스트")
    void add() {
        int result = calculator.add(1,1);
        assertEquals(2, result); // 기대값을 앞에 써야한다
    }

}