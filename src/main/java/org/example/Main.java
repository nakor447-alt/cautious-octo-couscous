package org.example;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+7-123-456-78-90");
        phoneBook.add("Иванов", "+7-987-654-32-10");
        phoneBook.add("Петрова", "+7-555-123-45-67");
        phoneBook.add("Сидоров", "+7-333-222-11-00");
        phoneBook.add("Иванов", "+7-111-222-33-44");

        System.out.println("Весь справочник:");
        phoneBook.printAll();

        System.out.println("\nНомера Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Номера Петровой: " + phoneBook.get("Петрова"));
        System.out.println("Номера Козлова (нет в справочнике): " + phoneBook.get("Козлов"));
    }
}