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
public class BlockTitleTest extends MtsBaseTest {

    @Test(description = "Проверка названия блока")
    @Description("Тест проверяет, что заголовок блока содержит 'Онлайн пополнение'")
    public void testBlockTitle() {
        HomePage homePage = new HomePage(driver);
        String title = getBlockTitle(homePage);
        Assert.assertTrue(title.contains("Онлайн пополнение"),
                "Заголовок блока не содержит 'Онлайн пополнение'");
    }

    @Step("Получение заголовка блока")
    private String getBlockTitle(HomePage homePage) {
        String title = homePage.getBlockTitle();
        System.out.println("Заголовок: " + title);
        return title;
    }
}