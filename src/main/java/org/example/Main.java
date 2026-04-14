package org.example;

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    private int row;
    private int col;
    private String wrongValue;

    public MyArrayDataException(int row, int col, String wrongValue) {
        super(String.format("Ошибка в ячейке [%d][%d]: значение '%s' не является числом", row, col, wrongValue));
        this.row = row;
        this.col = col;
        this.wrongValue = wrongValue;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public String getWrongValue() { return wrongValue; }
}

public class Main {

    public static int sumStringArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Ожидался массив 4x4, а получено строк: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        String.format("Ожидался массив 4x4, а строка %d имеет длину %d", i, array[i].length)
                );
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Тест 1: правильный массив ===");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int sum = sumStringArray(correctArray);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 2: неправильный размер (3x4) ===");
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };
        try {
            int sum = sumStringArray(wrongSizeArray);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 3: некорректные данные ===");
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "a", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int sum = sumStringArray(wrongDataArray);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 4: ArrayIndexOutOfBoundsException ===");
        int[] smallArray = new int[3];
        try {
            smallArray[5] = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e);
            System.out.println("Сообщение: " + e.getMessage());
        }
        System.out.println("Программа продолжает работу после обработки исключения.");
    }
}
