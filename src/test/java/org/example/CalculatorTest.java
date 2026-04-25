package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для класса Calculator")
class CalculatorTest {

    @Test
    @DisplayName("1. Сложение двух чисел")
    void testAddition() {
        assertEquals(5, Calculator.add(2, 3), "2 + 3 должно быть равно 5");
    }

    @Test
    @DisplayName("2. Вычитание двух чисел")
    void testSubtraction() {
        assertEquals(2, Calculator.subtract(5, 3), "5 - 3 должно быть равно 2");
    }

    @Test
    @DisplayName("3. Умножение двух чисел")
    void testMultiplication() {
        assertEquals(15, Calculator.multiply(3, 5), "3 × 5 должно быть равно 15");
    }

    @Test
    @DisplayName("4. Деление на ноль вызывает исключение")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> Calculator.divide(10, 0),
                "Деление на ноль должно вызвать исключение");
    }

    @ParameterizedTest
    @DisplayName("5. Параметризованный тест деления")
    @CsvSource({
            "10, 2, 5.0",
            "5, 2, 2.5",
            "-4, 2, -2.0",
            "0, 5, 0.0"
    })
    void testDivision(int a, int b, double expected) {
        assertEquals(expected, Calculator.divide(a, b), 0.001,
                () -> a + " / " + b + " должно быть равно " + expected);
    }
}