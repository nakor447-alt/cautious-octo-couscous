package org.example;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    // Метод для добавления еды в миску
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
        }
    }

    // Метод для взятия еды из миски (кот пытается съесть)
    public boolean takeFood(int amount) {
        if (foodAmount >= amount && amount > 0) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
