package org.example;

public interface Figure {


    String getFillColor();
    String getBorderColor();


    default double calculatePerimeter() {
        return 0;
    }

    default double calculateArea() {
        return 0;
    }


    default void displayInfo() {
        System.out.println("=== " + this.getClass().getSimpleName() + " ===");
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("Площадь: " + String.format("%.2f", calculateArea()));
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("-----------------------------");
    }
}