package org.example.tests;

import base.MtsBaseTest;
import org.example.pages.HomePage;
import org.example.pages.PaymentFramePage;
import org.testng.annotations.Test;

public class CommunicationServicePaymentTest extends MtsBaseTest {

    @Test
    public void testCommunicationServicePayment() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.selectCommunicationService();
        homePage.enterPhoneNumber("297777777");
        homePage.enterAmount("5");
        homePage.clickContinue();

        PaymentFramePage paymentFrame = new PaymentFramePage(driver);

        System.out.println("=== Результаты проверки ===");
        System.out.println("Сумма: " + paymentFrame.getDisplayedSum());
        System.out.println("Телефон: " + paymentFrame.getDisplayedPhoneNumber());

        // Пока просто выводим, без assert
        // Когда заработает — добавим проверки
    }
}