package org.example.tests;

import pages.HomePage;
import pages.PaymentFramePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlinePaymentTest extends MtsBaseTest {

    @Test(priority = 1)
    public void testOnlinePaymentBlock() {
        HomePage homePage = new HomePage(driver);

        // Проверка названия блока
        Assert.assertTrue(homePage.isOnlinePaymentBlockDisplayed(),
                "Блок 'Онлайн пополнение' не отображается");

        // Проверка логотипов платёжных систем
        Assert.assertTrue(homePage.arePaymentLogosDisplayed(),
                "Логотипы платёжных систем не отображаются");

        // Проверка ссылки "Подробнее о сервисе"
        homePage.clickMoreDetailsLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("help"),
                "Ссылка 'Подробнее' ведёт не на страницу помощи");
        driver.navigate().back();
    }

    @Test(priority = 2)
    public void testAllTabsPlaceholders() {
        HomePage homePage = new HomePage(driver);
        homePage.checkAllTabsPlaceholders();
    }

    @Test(priority = 3)
    public void testCommunicationServicePayment() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        // Выбираем услугу связи
        homePage.selectCommunicationService();
        Thread.sleep(500);

        // Заполняем поля
        homePage.enterPhoneNumber("297777777");
        homePage.enterAmount("5");

        // Нажимаем "Продолжить" и переключаемся на фрейм оплаты
        PaymentFramePage paymentFrame = homePage.clickContinue();

        // Проверяем, что форма оплаты открылась
        Assert.assertTrue(paymentFrame.isPaymentFormDisplayed(),
                "Форма оплаты не открылась");

        // Проверяем сумму на кнопке и на экране
        System.out.println("Сумма на экране: " + paymentFrame.getDisplayedAmount());
        System.out.println("Текст на кнопке: " + paymentFrame.getPayButtonText());
        Assert.assertTrue(paymentFrame.getDisplayedAmount().contains("5"),
                "Сумма на экране не соответствует 5 рублям");
        Assert.assertTrue(paymentFrame.getPayButtonText().contains("5"),
                "Сумма на кнопке не соответствует 5 рублям");

        // Проверяем номер телефона
        System.out.println("Номер телефона: " + paymentFrame.getDisplayedPhoneNumber());
        Assert.assertTrue(paymentFrame.getDisplayedPhoneNumber().contains("297777777"),
                "Номер телефона отображается некорректно");

        // Проверяем надписи в незаполненных полях карты
        System.out.println("Placeholder 'Номер карты': " + paymentFrame.getCardNumberFieldPlaceholder());
        System.out.println("Placeholder 'Срок': " + paymentFrame.getExpiryDateFieldPlaceholder());
        System.out.println("Placeholder 'CVC': " + paymentFrame.getCvcFieldPlaceholder());
        System.out.println("Placeholder 'Имя держателя': " + paymentFrame.getCardholderNameFieldPlaceholder());

        // Проверяем наличие иконок платёжных систем
        Assert.assertTrue(paymentFrame.arePaymentSystemIconsDisplayed(),
                "Иконки платёжных систем не отображаются в форме оплаты");
    }
}