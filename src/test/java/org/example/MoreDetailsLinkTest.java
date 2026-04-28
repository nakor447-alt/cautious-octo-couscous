package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoreDetailsLinkTest extends MtsBaseTest {

    @Test(priority = 3)
    public void testMoreDetailsLink() throws InterruptedException {
        removeCookieBanner();

        WebElement moreLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", moreLink);
        Thread.sleep(1000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Открытая ссылка: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("help") || currentUrl.contains("poryadok"),
                "Ссылка 'Подробнее' ведёт не туда: " + currentUrl);
    }
}