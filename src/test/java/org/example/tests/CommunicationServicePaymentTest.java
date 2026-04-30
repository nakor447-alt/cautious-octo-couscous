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
public class CommunicationServicePaymentTest extends MtsBaseTest {

    @Test(description = "Проверка ввода номера телефона")
    @Description("Тест проверяет, что номер телефона вводится в поле")
    public void testCommunicationServicePayment() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        // Выбрать услугу
        homePage.selectCommunicationService();

        // Ввести номер
        homePage.enterPhoneNumber("297777777");

        // ПРОВЕРКА: прочитать значение из поля
        String actualValue = homePage.getPhoneValue();
        System.out.println("Введённое значение: '" + actualValue + "'");

        Assert.assertTrue(actualValue.contains("297777777"),
                "Номер телефона не введён! В поле: '" + actualValue + "'");
    }
}