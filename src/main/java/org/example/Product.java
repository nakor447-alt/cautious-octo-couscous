package org.example;

public class Product {

    private String name;              // название
    private String productionDate;    // дата производства
    private String manufacturer;      // производитель
    private String countryOfOrigin;   // страна происхождения
    private double price;             // цена
    private boolean isBooked;         // забронирован или нет


    public Product(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isBooked = isBooked;
    }


    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Статус брони: " + (isBooked ? "Забронирован" : "Свободен"));
        System.out.println("-----------------------------");
    }
}