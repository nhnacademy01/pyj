package com.nhnacademy.yujinpark.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestDemo {
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void palindromes(String candidate) {
        // TODO isPalindrome = 기러기를 거꾸로 해도 기러기
        assertTrue(StringUtils.isPalindrome(candidate));
    }

    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testWithEnumSource(TemporalUnit unit) {
        assertNotNull(unit);
    }

    @ParameterizedTest
    @EnumSource
    // enum 사용한 것과 똑같이 동작하게 된다
    void testWithEnumSourceWithAutoDetection(ChronoUnit unit) {
        assertNotNull(unit);
    }

    @ParameterizedTest
    @EnumSource(mode = EXCLUDE, names = {"ERAS", "FOREVER"})
    // enum 상수를 명시
    void testWithEnumSourceExclude(ChronoUnit unit) {
        assertFalse(EnumSet.of(ChronoUnit.ERAS, ChronoUnit.FOREVER).contains(unit));
    }

    @ParameterizedTest
    @EnumSource(mode = MATCH_ALL, names = "^.*DAYS$")
    void testWithEnumSourceRegex(ChronoUnit unit) {
        assertTrue(unit.name().endsWith("DAYS"));
    }

    @DisplayName("Check valid argument(not null)")
    @ParameterizedTest(name = "{0} is not null")
    @MethodSource("stringProvider") // static method name
    void testWithExplicitLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    // 메소드 소스
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(5, str.length());
        assertTrue(num >= 1 && num <= 2);
        assertEquals(2, list.size());
    }

    // 위의 메소드 소스와 똑같다
    static Stream<Arguments> stringIntAndListProvider() {   // 복수 인자 넘기기
        return Stream.of(
            arguments("apple", 1, List.of("a", "b")),
            arguments("lemon", 2, List.of("x", "y"))
        );
    }
}