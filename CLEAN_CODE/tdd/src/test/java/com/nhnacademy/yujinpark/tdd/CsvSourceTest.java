package com.nhnacademy.yujinpark.tdd;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CsvSourceTest {
    @ParameterizedTest
    @CsvSource({
        "apple, 1",
        "banana, 2",
        "'lemon, lime', 0xF1"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/two-columns.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromClasspath(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/two-columns.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }
}