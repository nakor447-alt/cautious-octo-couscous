package org.example;

import org.testng.annotations.*;
import org.testng.Assert;

public class CalculatorTestNG {

    @Test(priority = 1)
    public void testAddition() {
        Assert.assertEquals(CalculatorNG.add(2, 3), 5);
    }

    @Test(priority = 2)
    public void testSubtraction() {
        Assert.assertEquals(CalculatorNG.subtract(5, 3), 2);
    }

    @Test(priority = 3)
    public void testMultiplication() {
        Assert.assertEquals(CalculatorNG.multiply(3, 5), 15);
    }

    @Test(priority = 4, expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        CalculatorNG.divide(10, 0);
    }

    @DataProvider(name = "divisionData")
    public Object[][] divisionData() {
        return new Object[][] {
                {10, 2, 5.0},
                {5, 2, 2.5},
                {-4, 2, -2.0},
                {0, 5, 0.0}
        };
    }

    @Test(priority = 5, dataProvider = "divisionData")
    public void testDivision(int a, int b, double expected) {
        Assert.assertEquals(CalculatorNG.divide(a, b), expected, 0.001);
    }
}