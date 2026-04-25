package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестирование Factorial:");

        System.out.println("0! = " + FactorialNG.calculate(0));  // Должно быть 1
        System.out.println("1! = " + FactorialNG.calculate(1));  // Должно быть 1
        System.out.println("5! = " + FactorialNG.calculate(5));  // Должно быть 120
    }
}