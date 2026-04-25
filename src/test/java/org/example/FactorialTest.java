package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для класса Factorial")
class FactorialTest {

    @Test
    @DisplayName("Факториал нуля должен быть равен 1")
    void testFactorialOfZero() {
        assertEquals(1, Factorial.calculate(0), "Факториал 0 должен быть равен 1");
    }

    @Test
    @DisplayName("Факториал единицы должен быть равен 1")
    void testFactorialOfOne() {
        assertEquals(1, Factorial.calculate(1), "Факториал 1 должен быть равен 1");
    }

    @Test
    @DisplayName("Факториал пяти должен быть равен 120")
    void testFactorialOfFive() {
        assertEquals(120, Factorial.calculate(5), "Факториал 5 должен быть равен 120");
    }

    @Test
    @DisplayName("Факториал отрицательного числа должен выбрасывать исключение")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> Factorial.calculate(-1),
                "Должно быть выброшено исключение для отрицательного числа");
    }

    @ParameterizedTest
    @DisplayName("Параметризованный тест факториала")
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
    })
    void testFactorialParameterized(int input, long expected) {
        assertEquals(expected, Factorial.calculate(input),
                () -> "Факториал " + input + " должен быть равен " + expected);
    }
}