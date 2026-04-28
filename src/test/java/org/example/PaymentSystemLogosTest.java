package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PaymentSystemLogosTest extends MtsBaseTest {

    @Test(priority = 2)
    public void testPaymentSystemLogos() {
        removeCookieBanner();

        List<WebElement> logos = driver.findElements(By.xpath(
                "//div[contains(@class, 'pay')]//img[contains(@src, 'mastercard') or contains(@src, 'visa')]"
        ));

        System.out.println("Найдено логотипов платёжных систем: " + logos.size());
        Assert.assertTrue(logos.size() >= 2, "Должно быть минимум 2 логотипа (Visa, Mastercard)");
    }
}