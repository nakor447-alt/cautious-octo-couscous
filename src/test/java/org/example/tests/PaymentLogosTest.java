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
public class PaymentLogosTest extends MtsBaseTest {

    @Test(description = "Проверка наличия логотипов платёжных систем")
    @Description("Тест проверяет, что на странице отображаются логотипы Visa и MasterCard")
    public void testPaymentLogos() {
        HomePage homePage = new HomePage(driver);
        boolean logosDisplayed = checkPaymentLogos(homePage);
        Assert.assertTrue(logosDisplayed,
                "Логотипы платёжных систем не отображаются");
    }

    @Step("Проверка отображения логотипов платёжных систем")
    private boolean checkPaymentLogos(HomePage homePage) {
        boolean result = homePage.arePaymentLogosDisplayed();
        System.out.println("Логотипы отображаются: " + result);
        return result;
    }
}