package org.example;

public class FactorialNG {

    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел");
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            if (result < 0) {
                throw new ArithmeticException("Переполнение: результат слишком большой для типа long");
            }
        }
        return result;
    }
}
