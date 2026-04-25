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

    @ParameterizedTest
    @DisplayName("Параметризованный тест факториала")
    @CsvSource({
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
    })
    void testFactorialParameterized(int input, long expected) {
        assertEquals(expected, Factorial.calculate(input),
                () -> String.format("Факториал %d должен быть равен %d", input, expected));
    }

    @Test
    @DisplayName("Факториал отрицательного числа должен выбрасывать исключение")
    void testFactorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> Factorial.calculate(-1),
                "Должно быть выброшено исключение для отрицательного числа");
    }

    @Test
    @DisplayName("Тест переполнения")
    void testFactorialOverflow() {
        assertThrows(ArithmeticException.class,
                () -> Factorial.calculate(21),
                "Факториал 21 должен вызвать переполнение");
    }
}
