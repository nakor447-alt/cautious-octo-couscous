package org.example;

import org.testng.annotations.*;
import org.testng.Assert;

public class NumberComparatorTestNG {

    @Test(priority = 1)
    public void testCompare() {
        Assert.assertTrue(NumberComparatorNG.compare(5, 3) > 0);
        Assert.assertTrue(NumberComparatorNG.compare(3, 5) < 0);
        Assert.assertEquals(NumberComparatorNG.compare(4, 4), 0);
    }

    @Test(priority = 2)
    public void testIsGreater() {
        Assert.assertTrue(NumberComparatorNG.isGreater(5, 3));
        Assert.assertFalse(NumberComparatorNG.isGreater(3, 5));
    }

    @Test(priority = 3)
    public void testIsEqual() {
        Assert.assertTrue(NumberComparatorNG.isEqual(10, 10));
        Assert.assertFalse(NumberComparatorNG.isEqual(5, 6));
    }

    @Test(priority = 4)
    public void testMax() {
        Assert.assertEquals(NumberComparatorNG.max(5, 3), 5);
        Assert.assertEquals(NumberComparatorNG.max(-1, -5), -1);
    }

    @DataProvider(name = "signData")
    public Object[][] signData() {
        return new Object[][] {
                {5, "Positive"},
                {-3, "Negative"},
                {0, "Zero"},
                {100, "Positive"},
                {-50, "Negative"}
        };
    }

    @Test(priority = 5, dataProvider = "signData")
    public void testGetSign(int number, String expected) {
        Assert.assertEquals(NumberComparatorNG.getSign(number), expected);
    }
}