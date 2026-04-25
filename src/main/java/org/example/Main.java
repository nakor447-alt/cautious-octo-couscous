package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Демонстрация работы Factorial:");

        System.out.println("0! = " + Factorial.calculate(0));
        System.out.println("1! = " + Factorial.calculate(1));
        System.out.println("5! = " + Factorial.calculate(5));

        System.out.println("\nДемонстрация работы Calculator:");
        System.out.println("2 + 3 = " + Calculator.add(2, 3));
        System.out.println("10 / 2 = " + Calculator.divide(10, 2));

        System.out.println("\nПрограмма работает успешно!");
    }
}