package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentFramePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentFramePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try { Thread.sleep(5000); } catch (Exception ignored) {}

        // Проверяем, есть ли iframe
        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        System.out.println("=== Найдено iframe: " + iframes.size());

        if (!iframes.isEmpty()) {
            try {
                // Ждём загрузки iframe
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframes.get(0)));
                System.out.println("Переключились на iframe");

                // Ждём появления любого элемента внутри iframe
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body")));
                System.out.println("iframe загружен");
            } catch (Exception e) {
                System.out.println("Ошибка при переключении на iframe: " + e.getMessage());
            }
        }
    }

    public boolean isPaymentFormDisplayed() {
        return !driver.findElements(By.xpath("//input | //form | //button")).isEmpty();
    }

    public String getDisplayedPhoneNumber() {
        try {
            // Ждём появления текста
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[contains(text(),'375')] | //*[contains(text(),'297')]")));
        } catch (Exception e) {
            System.out.println("Текст с номером не появился");
        }

        // Выводим весь текст
        String pageText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("=== Текст на странице оплаты ===");
        System.out.println(pageText);
        System.out.println("=== Конец текста ===");

        // Ищем номер
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'297777777') or contains(text(),'375')]"));
        System.out.println("Найдено элементов с номером: " + elements.size());

        if (!elements.isEmpty()) {
            return elements.get(0).getText();
        }
        return "Номер не найден";
    }

    public String getDisplayedSum() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'5')]"));
        if (!elements.isEmpty()) {
            return elements.get(0).getText();
        }
        return "Сумма не найдена";
    }
}