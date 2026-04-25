package org.example;

import org.testng.annotations.*;
import org.testng.Assert;

public class TriangleAreaTestNG {

    @Test(priority = 1)
    public void testAreaByBaseAndHeight() {
        Assert.assertEquals(TriangleAreaNG.calculateByBaseAndHeight(5.0, 4.0), 10.0, 0.001);
    }

    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class)
    public void testNegativeBase() {
        TriangleAreaNG.calculateByBaseAndHeight(-5.0, 4.0);
    }

    @Test(priority = 3)
    public void testHeronFormula() {
        Assert.assertEquals(TriangleAreaNG.calculateByHeron(3, 4, 5), 6.0, 0.001);
    }

    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangle() {
        TriangleAreaNG.calculateByHeron(1, 1, 3);
    }

    @DataProvider(name = "legsData")
    public Object[][] legsData() {
        return new Object[][] {
                {3.0, 4.0, 6.0},
                {5.0, 12.0, 30.0},
                {1.0, 1.0, 0.5}
        };
    }

    @Test(priority = 5, dataProvider = "legsData")
    public void testAreaByLegs(double leg1, double leg2, double expected) {
        Assert.assertEquals(TriangleAreaNG.calculateByLegs(leg1, leg2), expected, 0.001);
    }
}