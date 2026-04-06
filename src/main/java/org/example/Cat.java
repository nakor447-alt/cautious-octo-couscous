package org.example;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;  // сытость

    public Cat(String name) {
        super(name, 200, 0);  // коты не умеют плавать
        this.isFull = false;   // при создании кот голодный
        catCount++;
    }

    // Метод для еды из миски
    public void eat(Bowl bowl, int amount) {
        if (bowl.takeFood(amount)) {
            isFull = true;
            System.out.println(name + " поел " + amount + " еды и теперь сыт");
        } else {
            System.out.println(name + " не стал есть (недостаточно еды в миске)");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}
