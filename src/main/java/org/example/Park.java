package org.example;

public class Park {
    private String name;   // название парка


    public Park(String name) {
        this.name = name;
    }


    public class Attraction {
        private String attractionName;    // название аттракциона
        private String workingHours;      // время работы
        private double cost;              // стоимость


        public Attraction(String attractionName, String workingHours, double cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }


        public void displayInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена билета: " + cost + " руб.");
            System.out.println("-----------------------------");
        }
    }
}