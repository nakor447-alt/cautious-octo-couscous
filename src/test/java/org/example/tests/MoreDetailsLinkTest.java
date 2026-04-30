package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import base.MtsBaseTest;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
@Feature("Блок 'Онлайн пополнение без комиссии'")
public class MoreDetailsLinkTest extends MtsBaseTest {

    @Test(description = "Проверка работы ссылки 'Подробнее о сервисе'")
    @Description("Тест проверяет, что ссылка 'Подробнее' ведёт на другую страницу")
    public void testMoreDetailsLink() {
        HomePage homePage = new HomePage(driver);
        clickMoreDetailsLink(homePage);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, "https://www.mts.by",
                "Ссылка 'Подробнее' не ведёт на новую страницу");
    }

    @Step("Нажатие на ссылку 'Подробнее о сервисе'")
    private void clickMoreDetailsLink(HomePage homePage) {
        homePage.clickMoreDetailsLink();
        System.out.println("Ссылка 'Подробнее' нажата");
    }
}