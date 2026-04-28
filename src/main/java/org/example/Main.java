package org.example;

public class Main {
    public static void main(String[] args) {
        // Создаем фигуры
        Circle circle = new Circle(5.0, "Красный", "Черный");
        Rectangle rectangle = new Rectangle(4.0, 6.0, "Синий", "Желтый");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, "Зеленый", "Оранжевый");

        // Выводим информацию о каждой фигуре
        circle.displayInfo();
        rectangle.displayInfo();
        triangle.displayInfo();

        // Дополнительно: демонстрация полиморфизма
        System.out.println("\n=== Демонстрация полиморфизма ===");
        Figure[] figures = {circle, rectangle, triangle};
        for (Figure figure : figures) {
            System.out.println(figure.getClass().getSimpleName() +
                    ": Площадь = " + String.format("%.2f", figure.calculateArea()) +
                    ", Периметр = " + String.format("%.2f", figure.calculatePerimeter()));
        }
    }
}