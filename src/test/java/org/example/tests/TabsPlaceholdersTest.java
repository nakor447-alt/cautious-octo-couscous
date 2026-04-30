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
public class TabsPlaceholdersTest extends MtsBaseTest {

    @Test(description = "Проверка плейсхолдеров: Услуги связи")
    @Description("Тест проверяет плейсхолдеры полей для вкладки 'Услуги связи'")
    public void testPlaceholdersCommunicationService() {
        HomePage homePage = new HomePage(driver);
        checkPlaceholders(homePage, "Услуги связи");
    }

    @Test(description = "Проверка плейсхолдеров: Домашний интернет")
    @Description("Тест проверяет плейсхолдеры полей для вкладки 'Домашний интернет'")
    public void testPlaceholdersInternet() {
        HomePage homePage = new HomePage(driver);
        homePage.selectInternetService();
        checkPlaceholders(homePage, "Домашний интернет");
    }

    @Test(description = "Проверка плейсхолдеров: Рассрочка")
    @Description("Тест проверяет плейсхолдеры полей для вкладки 'Рассрочка'")
    public void testPlaceholdersInstallment() {
        HomePage homePage = new HomePage(driver);
        homePage.selectInstallmentService();
        checkPlaceholders(homePage, "Рассрочка");
    }

    @Test(description = "Проверка плейсхолдеров: Задолженность")
    @Description("Тест проверяет плейсхолдеры полей для вкладки 'Задолженность'")
    public void testPlaceholdersDebt() {
        HomePage homePage = new HomePage(driver);
        homePage.selectDebtService();
        checkPlaceholders(homePage, "Задолженность");
    }

    @Step("Проверка плейсхолдеров для вкладки '{service}'")
    private void checkPlaceholders(HomePage homePage, String service) {
        String phone = homePage.getPhonePlaceholder();
        String sum = homePage.getSumPlaceholder();
        String email = homePage.getEmailPlaceholder();

        System.out.println("=== " + service + " ===");
        System.out.println("Телефон: " + phone);
        System.out.println("Сумма: " + sum);
        System.out.println("Email: " + email);

        Assert.assertNotNull(phone, "Плейсхолдер телефона пуст");
        Assert.assertNotNull(sum, "Плейсхолдер суммы пуст");
        Assert.assertNotNull(email, "Плейсхолдер email пуст");
    }
}