package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== ЗАДАНИЕ 1 и 2: Товары =====\n");


        Product[] productsArray = new Product[5];


        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro", "15.03.2025", "Apple Inc.", "USA", 8999, false);
        productsArray[2] = new Product("Xiaomi 14", "10.01.2025", "Xiaomi Corp.", "China", 3499, true);
        productsArray[3] = new Product("Google Pixel 9", "20.02.2025", "Google LLC", "USA", 4999, false);
        productsArray[4] = new Product("OnePlus 12", "05.03.2025", "OnePlus", "China", 3999, true);


        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Товар №" + (i + 1));
            productsArray[i].displayInfo();
        }

        System.out.println("\n===== ЗАДАНИЕ 3: Аттракционы =====\n");


        Park centralPark = new Park("Центральный парк");


        Park.Attraction attraction1 = centralPark.new Attraction("Колесо обозрения", "10:00-22:00", 250);
        Park.Attraction attraction2 = centralPark.new Attraction("Американские горки", "11:00-21:00", 400);
        Park.Attraction attraction3 = centralPark.new Attraction("Автодром", "10:00-20:00", 200);


        attraction1.displayInfo();
        attraction2.displayInfo();
        attraction3.displayInfo();
    }
}