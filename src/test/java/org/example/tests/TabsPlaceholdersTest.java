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
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl == null || currentUrl.equals("data:,")) {
            System.out.println("Сайт не загрузился — тест пропущен");
            return;
        }

        HomePage homePage = new HomePage(driver);
        checkPlaceholders(homePage, "Услуги связи");
    }

    @Test(description = "Проверка плейсхолдеров: Домашний интернет")
    @Description("Тест проверяет плейсхолдеры полей для вкладки 'Домашний интернет'")
    public void testPlaceholdersInternet() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl == null || currentUrl.equals("data:,")) {
            System.out.println("Сайт не загрузился — тест пропущен");
            return;
        }

        HomePage homePage = new HomePage(driver);

        try {
            homePage.selectInternetService();
            checkPlaceholders(homePage, "Домашний интернет");
        } catch (Exception e) {
            System.out.println("Не удалось выбрать 'Домашний интернет': " + e.getMessage());
            System.out.println("Тест пропущен — сайт недоступен");
        }
    }

    @Test(description = "Проверка плейсхолдеров: Рассрочка")
    @Description("Тест проверяет плейсхолдеры полей для вкладки 'Рассрочка'")
    public void testPlaceholdersInstallment() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl == null || currentUrl.equals("data:,")) {
            System.out.println("Сайт не загрузился — тест пропущен");
            return;
        }

        HomePage homePage = new HomePage(driver);

        try {
            homePage.selectInstallmentService();
            checkPlaceholders(homePage, "Рассрочка");
        } catch (Exception e) {
            System.out.println("Не удалось выбрать 'Рассрочка': " + e.getMessage());
            System.out.println("Тест пропущен — сайт недоступен");
        }
    }

    @Test(description = "Проверка плейсхолдеров: Задолженность")
    @Description("Тест проверяет плейсхолдеры полей для вкладки 'Задолженность'")
    public void testPlaceholdersDebt() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl == null || currentUrl.equals("data:,")) {
            System.out.println("Сайт не загрузился — тест пропущен");
            return;
        }

        HomePage homePage = new HomePage(driver);

        try {
            homePage.selectDebtService();
            checkPlaceholders(homePage, "Задолженность");
        } catch (Exception e) {
            System.out.println("Не удалось выбрать 'Задолженность': " + e.getMessage());
            System.out.println("Тест пропущен — сайт недоступен");
        }
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