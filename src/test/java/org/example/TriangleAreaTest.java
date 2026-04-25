package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для класса TriangleArea")
class TriangleAreaTest {

    @Test
    @DisplayName("1. Площадь по основанию и высоте")
    void testAreaByBaseAndHeight() {
        assertEquals(10.0, TriangleArea.calculateByBaseAndHeight(5.0, 4.0), 0.001,
                "Площадь треугольника 5×4 должна быть 10");
    }

    @Test
    @DisplayName("2. Отрицательное основание вызывает исключение")
    void testNegativeBase() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.calculateByBaseAndHeight(-5.0, 4.0),
                "Отрицательное основание должно вызвать исключение");
    }

    @Test
    @DisplayName("3. Площадь по формуле Герона (3-4-5)")
    void testHeronFormula() {
        assertEquals(6.0, TriangleArea.calculateByHeron(3, 4, 5), 0.001,
                "Площадь треугольника 3-4-5 должна быть 6");
    }

    @Test
    @DisplayName("4. Неправильный треугольник вызывает исключение")
    void testInvalidTriangle() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.calculateByHeron(1, 1, 3),
                "Стороны 1-1-3 не образуют треугольник");
    }

    @ParameterizedTest
    @DisplayName("5. Параметризованный тест площади по катетам")
    @CsvSource({
            "3.0, 4.0, 6.0",
            "5.0, 12.0, 30.0",
            "1.0, 1.0, 0.5"
    })
    void testAreaByLegs(double leg1, double leg2, double expected) {
        assertEquals(expected, TriangleArea.calculateByLegs(leg1, leg2), 0.001,
                () -> "Площадь с катетами " + leg1 + " и " + leg2 + " должна быть " + expected);
    }
}