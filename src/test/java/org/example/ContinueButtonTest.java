package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ContinueButtonTest extends MtsBaseTest {

    @Test(priority = 4)
    public void testContinueButton() throws InterruptedException {
        removeCookieBanner();

        // Прокручиваем к блоку "Онлайн пополнение" (просто к тексту)
        WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(), 'Онлайн пополнение')]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", titleElement);
        Thread.sleep(500);

        // Нажимаем на кнопку "Услуги связи"
        WebElement serviceBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(), 'Услуги связи')]")
        ));
        serviceBtn.click();
        Thread.sleep(500);

        // Поле "Номер телефона"
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@placeholder, 'Номер') or contains(@placeholder, 'телефон')]")
        ));
        phoneField.sendKeys("297777777");

        // Поле "Сумма"
        WebElement sumField = driver.findElement(By.xpath("//input[contains(@placeholder, 'Сумма')]"));
        sumField.sendKeys("5");

        // Кнопка "Продолжить"
        WebElement continueBtn = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);

        Thread.sleep(2000);
        System.out.println("Кнопка 'Продолжить' нажата.");
    }
}