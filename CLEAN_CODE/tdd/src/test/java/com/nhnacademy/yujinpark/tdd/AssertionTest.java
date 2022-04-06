package com.nhnacademy.yujinpark.tdd;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AssertionTest {
    // assertion ~ 여야만 한다
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Jordan", "Jeong");

    @Test
    void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        // TODO 테스트가 통과되게 구현해주세요.
        assertEquals(4, calculator.multiply(2, 2), "추가적인 실패 메세지는 마지막 파라미터에 넣는다.");
        assertTrue('a' < 'b', () -> "Assertion messages는 지연로딩과 비슷하게 동작한다. -- "
            + "불필요하게 메세지를 만드는 일을 피하기 위해서.");
        // 함수를 만들어서 던진거지 내부적으로 실행된 것은 아니다 (지연로딩)
        // 메세지를 만드는 함수를 만든거지 실행시키지는 않은 상태 (지연로딩)
    }

    @Test
    void groupedAssertions() {
        // TODO 테스트가 통과되게 구현해주세요.
        assertAll("person",
            () -> assertEquals("Jordan", person.getFirstName()),
            () -> assertEquals("Jeong", person.getLastName()));
    }

    @Test
    void dependentAssertions() {
        assertAll("properties",
            () -> {
                String firstName = person.getFirstName();
                assertNotNull(firstName);
                assertAll("first name",
                    () -> assertTrue(firstName.startsWith("J")),
                    () -> assertTrue(firstName.endsWith("n"))
                );
            },
            () -> {
                String lastName = person.getLastName();
                assertNotNull(lastName);
                assertAll("last name",
                    () -> assertTrue(lastName.startsWith("J")),
                    () -> assertTrue(lastName.endsWith("g"))
                );
            }
        );
    }

    @Test
    void exceptionTesting() {
        // TODO: 테스트가 성공할 수 있게 구현해주세요.
        Exception exception = assertThrows(ArithmeticException.class, () ->
            calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }


    @Test
    void timeoutNotExceeded() {
        // 아래의 assertion은 성공.
        assertTimeout(ofMinutes(2), () -> {
            // 2분 미만으로 실행되는 동작 실행
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        //아래의 assertion은 성공하면서 supplied 객체를 반환한다.
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            return "a result";
        });
        assertEquals("a result", actualResult);
    }

    @Test
    void timeoutExceeded() {
        //이 테스트는 fail이 난다.
        assertTimeout(ofMillis(10), () -> {
            // 10ms 이상 걸리는 작업
            Thread.sleep(100);
        });
    }
}