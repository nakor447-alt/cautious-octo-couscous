package org.example.tests;

import base.MtsBaseTest;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentLogosTest extends MtsBaseTest {

    @Test
    public void testPaymentLogos() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.arePaymentLogosDisplayed(),
                "Логотипы платёжных систем не отображаются");
        System.out.println("Логотипы платёжных систем отображаются");
    }
}