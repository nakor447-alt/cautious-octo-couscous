package org.example.tests;

import base.MtsBaseTest;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TabsPlaceholdersTest extends MtsBaseTest {

    @Test
    public void testPlaceholdersCommunicationService() {
        HomePage homePage = new HomePage(driver);
        homePage.selectCommunicationService();

        System.out.println("=== Услуги связи ===");
        String phone = homePage.getPhonePlaceholder();
        String sum = homePage.getSumPlaceholder();
        String email = homePage.getEmailPlaceholder();

        System.out.println("Телефон: " + phone);
        System.out.println("Сумма: " + sum);
        System.out.println("Email: " + email);

        Assert.assertNotNull(phone, "Плейсхолдер телефона пуст");
        Assert.assertNotNull(sum, "Плейсхолдер суммы пуст");
        Assert.assertNotNull(email, "Плейсхолдер email пуст");
    }

    @Test
    public void testPlaceholdersInternet() {
        HomePage homePage = new HomePage(driver);
        homePage.selectInternetService();

        System.out.println("=== Домашний интернет ===");
        String phone = homePage.getPhonePlaceholder();
        String sum = homePage.getSumPlaceholder();
        String email = homePage.getEmailPlaceholder();

        System.out.println("Телефон: " + phone);
        System.out.println("Сумма: " + sum);
        System.out.println("Email: " + email);

        Assert.assertNotNull(phone, "Плейсхолдер телефона пуст");
        Assert.assertNotNull(sum, "Плейсхолдер суммы пуст");
        Assert.assertNotNull(email, "Плейсхолдер email пуст");
    }

    @Test
    public void testPlaceholdersInstallment() {
        HomePage homePage = new HomePage(driver);
        homePage.selectInstallmentService();

        try { Thread.sleep(1000); } catch (Exception ignored) {}

        System.out.println("=== Рассрочка ===");
        String phone = homePage.getPhonePlaceholder();
        String sum = homePage.getSumPlaceholder();
        String email = homePage.getEmailPlaceholder();

        System.out.println("Телефон: " + phone);
        System.out.println("Сумма: " + sum);
        System.out.println("Email: " + email);

        Assert.assertNotNull(phone, "Плейсхолдер телефона пуст");
        Assert.assertNotNull(sum, "Плейсхолдер суммы пуст");
        Assert.assertNotNull(email, "Плейсхолдер email пуст");
    }

    @Test
    public void testPlaceholdersDebt() {
        HomePage homePage = new HomePage(driver);
        homePage.selectDebtService();

        try { Thread.sleep(1000); } catch (Exception ignored) {}

        System.out.println("=== Задолженность ===");
        String phone = homePage.getPhonePlaceholder();
        String sum = homePage.getSumPlaceholder();
        String email = homePage.getEmailPlaceholder();

        System.out.println("Телефон: " + phone);
        System.out.println("Сумма: " + sum);
        System.out.println("Email: " + email);

        Assert.assertNotNull(phone, "Плейсхолдер телефона пуст");
        Assert.assertNotNull(sum, "Плейсхолдер суммы пуст");
        Assert.assertNotNull(email, "Плейсхолдер email пуст");
    }
}