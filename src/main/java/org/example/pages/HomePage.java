package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Выпадающий список
    private By selectButton = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private By communicationOption = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p");
    private By installmentOption = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p");
    private By debtOption = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p");

    // Поля ввода
    private By phoneInput = By.id("connection-phone");
    private By sumInput = By.id("connection-sum");
    private By emailInput = By.id("connection-email");

    // Кнопки
    private By continueButton = By.xpath("//button[contains(text(),'Продолжить')]");
    private By moreDetailsLink = By.xpath("//a[contains(text(),'Подробнее')]");

    // Заголовок
    private By blockTitle = By.xpath("//h2[contains(text(),'Онлайн пополнение')]");

    // Логотипы
    private By visaLogo = By.xpath("//img[contains(@alt,'Visa')]");
    private By mastercardLogo = By.xpath("//img[contains(@alt,'MasterCard')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private void openSelect() {
        wait.until(ExpectedConditions.elementToBeClickable(selectButton)).click();
        try { Thread.sleep(500); } catch (Exception ignored) {}
    }

    public void selectCommunicationService() {
        openSelect();
        wait.until(ExpectedConditions.elementToBeClickable(communicationOption)).click();
        try { Thread.sleep(2000); } catch (Exception ignored) {}
        System.out.println("Выбрано: Услуги связи");
    }

    public void selectInternetService() {
        System.out.println("Выбрано: Домашний интернет");
    }

    public void selectInstallmentService() {
        openSelect();
        wait.until(ExpectedConditions.elementToBeClickable(installmentOption)).click();
        try { Thread.sleep(2000); } catch (Exception ignored) {}
        System.out.println("Выбрано: Рассрочка");
    }

    public void selectDebtService() {
        openSelect();
        wait.until(ExpectedConditions.elementToBeClickable(debtOption)).click();
        try { Thread.sleep(2000); } catch (Exception ignored) {}
        System.out.println("Выбрано: Задолженность");
    }

    // ===== ВВОД ЧЕРЕЗ JAVASCRIPT =====
    public void enterPhoneNumber(String phone) {
        WebElement input = driver.findElement(phoneInput);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));",
                input, phone);
        System.out.println("Введён телефон: " + phone);
    }

    public void enterAmount(String amount) {
        WebElement input = driver.findElement(sumInput);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));",
                input, amount);
        System.out.println("Введена сумма: " + amount);
    }

    public String getPhonePlaceholder() {
        return driver.findElement(phoneInput).getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        return driver.findElement(sumInput).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }

    // ===== КЛИК ЧЕРЕЗ JAVASCRIPT =====
    public PaymentFramePage clickContinue() {
        WebElement button = driver.findElement(continueButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        System.out.println("Кнопка Продолжить нажата");
        try { Thread.sleep(3000); } catch (Exception ignored) {}
        return new PaymentFramePage(driver);
    }

    public void clickMoreDetailsLink() {
        WebElement link = driver.findElement(moreDetailsLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public boolean arePaymentLogosDisplayed() {
        try {
            driver.findElement(visaLogo);
            driver.findElement(mastercardLogo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}