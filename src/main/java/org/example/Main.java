package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== ЧАСТЬ 1: Животные =====\n");

        // Создаём животных
        Dog bobik = new Dog("Бобик");
        Dog rex = new Dog("Рекс");
        Cat murka = new Cat("Мурка");
        Cat barsik = new Cat("Барсик");
        Cat tom = new Cat("Том");

        // Проверяем бег и плавание
        bobik.run(150);
        bobik.run(600);
        bobik.swim(5);
        bobik.swim(15);

        murka.run(180);
        murka.run(250);
        murka.swim(5);

        System.out.println("\n===== Статистика =====");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

        System.out.println("\n===== ЧАСТЬ 2: Коты и миска =====\n");

        // Создаём миску с 30 ед. еды
        Bowl bowl = new Bowl(30);

        // Массив котов
        Cat[] cats = {murka, barsik, tom};

        // Коты пытаются поесть
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        System.out.println("\n=== Результат сытости котов ===");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isFull() ? "Сыт" : "Голоден"));
        }

        // Добавляем еду в миску
        System.out.println("\n=== Добавляем еду в миску ===");
        bowl.addFood(20);

        // Пусть голодный кот поест
        System.out.println("\n=== Том пробует поесть снова ===");
        tom.eat(bowl, 15);

        System.out.println("\n=== Финальный статус котов ===");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isFull() ? "Сыт" : "Голоден"));
        }
        System.out.println("Осталось еды в миске: " + bowl.getFoodAmount());
    }
}
