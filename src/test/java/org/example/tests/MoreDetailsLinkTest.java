package org.example.tests;

import base.MtsBaseTest;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoreDetailsLinkTest extends MtsBaseTest {

    @Test
    public void testMoreDetailsLink() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMoreDetailsLink();

        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL после перехода: " + currentUrl);

        Assert.assertTrue(currentUrl.contains("help") || !currentUrl.equals("https://www.mts.by"),
                "Ссылка 'Подробнее' не ведёт на новую страницу");
    }
}