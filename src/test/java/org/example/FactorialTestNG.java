package org.example;

import org.testng.annotations.*;
import org.testng.Assert;

public class FactorialTestNG {

    @Test(priority = 1)
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialNG.calculate(0), 1);
    }

    @Test(priority = 2)
    public void testFactorialOfOne() {
        Assert.assertEquals(FactorialNG.calculate(1), 1);
    }

    @Test(priority = 3)
    public void testFactorialOfFive() {
        Assert.assertEquals(FactorialNG.calculate(5), 120);
    }

    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        FactorialNG.calculate(-1);
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][] {
                {0, 1L},
                {1, 1L},
                {2, 2L},
                {3, 6L},
                {4, 24L},
                {5, 120L}
        };
    }

    @Test(priority = 5, dataProvider = "factorialData")
    public void testFactorialParameterized(int input, long expected) {
        Assert.assertEquals(FactorialNG.calculate(input), expected);
    }
}