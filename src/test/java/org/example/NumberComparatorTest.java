package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для класса NumberComparator")
class NumberComparatorTest {

    @Test
    @DisplayName("1. Сравнение двух чисел")
    void testCompare() {
        assertTrue(NumberComparator.compare(5, 3) > 0, "5 должно быть больше 3");
        assertTrue(NumberComparator.compare(3, 5) < 0, "3 должно быть меньше 5");
        assertEquals(0, NumberComparator.compare(4, 4), "4 должно быть равно 4");
    }

    @Test
    @DisplayName("2. Проверка isGreater")
    void testIsGreater() {
        assertTrue(NumberComparator.isGreater(5, 3), "5 должно быть больше 3");
        assertFalse(NumberComparator.isGreater(3, 5), "3 не должно быть больше 5");
        assertFalse(NumberComparator.isGreater(5, 5), "5 не должно быть больше 5");
    }

    @Test
    @DisplayName("3. Проверка isEqual")
    void testIsEqual() {
        assertTrue(NumberComparator.isEqual(10, 10), "10 должно быть равно 10");
        assertFalse(NumberComparator.isEqual(5, 6), "5 не должно быть равно 6");
    }

    @Test
    @DisplayName("4. Поиск максимального числа")
    void testMax() {
        assertEquals(5, NumberComparator.max(5, 3), "Максимум из 5 и 3 должен быть 5");
        assertEquals(7, NumberComparator.max(7, 7), "Максимум из 7 и 7 должен быть 7");
        assertEquals(-1, NumberComparator.max(-1, -5), "Максимум из -1 и -5 должен быть -1");
    }

    @ParameterizedTest
    @DisplayName("5. Параметризованный тест знака числа")
    @CsvSource({
            "5, Positive",
            "-3, Negative",
            "0, Zero",
            "100, Positive",
            "-50, Negative"
    })
    void testGetSign(int number, String expected) {
        assertEquals(expected, NumberComparator.getSign(number),
                () -> "Знак числа " + number + " должен быть " + expected);
    }
}