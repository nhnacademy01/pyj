package com.nhnacademy.yujinpark.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// 테스트는 순서를 보장하지 않는다
class DisplayNameGeneratorDemo {
    @Nested // 하나의 클래스 안에 중첩 클래스로 만든 것
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    // ReplaceUnderscores 는 _를 스페이스로 바꿔주는 것
    class A_year_is_not_supported {
        @Test
        void if_it_is_zero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        // 네이밍 룰을 무시하고 이 룰을 적용
        // 기본 룰보다 내가 테스트에 먹인 룰 적용
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        // 경계조건을 테스트 할 때 많이 쓴다
        @ValueSource(ints = { -1, -4 })
        // 여러개의 인자 받을 수 있음
        void if_it_is_negative(int year) { // year라는 인자로 테스트를 여러번 돌 수 있음
        }
    }
    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
    // 클래스랑 메소드명 이어줄 때 사용하는듯?
    class A_year_is_a_leap_year {

        @Test
        void if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = { 2016, 2020, 2048 })
        void if_it_is_one_of_the_following_years(int year) {
        }
    }
}
