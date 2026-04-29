package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import base.MtsBaseTest;
import io.qameta.allure.testng.AllureTestNg;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.AllureTestListener;

@Listeners({AllureTestNg.class})
@Feature("Блок Онлайн пополнение без комиссии")
public class MtsAllureReportTest extends MtsBaseTest {

    @Test(description = "Проверка заголовка блока")
    @Description("Тест проверяет заголовок блока")
    public void testBlockTitle() {
        String title = getBlockTitle();
        Assert.assertTrue(title.contains("Онлайн пополнение"),
                "Заголовок не содержит 'Онлайн пополнение'");
    }

    @Step("Получение заголовка")
    private String getBlockTitle() {
        HomePage homePage = new HomePage(driver);
        return homePage.getBlockTitle();
    }
}