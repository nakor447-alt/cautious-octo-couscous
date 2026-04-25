package org.example;

public class TriangleArea {

    public static double calculateByBaseAndHeight(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными числами");
        }
        return (base * height) / 2.0;
    }

    public static double calculateByHeron(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными числами");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Стороны не образуют треугольник");
        }

        double semiPerimeter = (a + b + c) / 2.0;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) *
                (semiPerimeter - b) * (semiPerimeter - c));
    }

    public static double calculateByLegs(double leg1, double leg2) {
        if (leg1 <= 0 || leg2 <= 0) {
            throw new IllegalArgumentException("Катеты должны быть положительными числами");
        }
        return (leg1 * leg2) / 2.0;
    }
}