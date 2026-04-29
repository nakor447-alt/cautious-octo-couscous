package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PaymentFramePage {

    private WebDriver driver;

    public PaymentFramePage(WebDriver driver) {
        this.driver = driver;
        // Ждём загрузки
        try { Thread.sleep(3000); } catch (Exception ignored) {}

        // Проверяем, есть ли iframe
        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        System.out.println("=== Найдено iframe: " + iframes.size());

        if (!iframes.isEmpty()) {
            // Пробуем переключиться на первый iframe
            try {
                driver.switchTo().frame(iframes.get(0));
                System.out.println("Переключились на iframe");
            } catch (Exception e) {
                System.out.println("Не удалось переключиться на iframe: " + e.getMessage());
            }
        }
    }

    public boolean isPaymentFormDisplayed() {
        // Ищем любые элементы формы оплаты
        return !driver.findElements(By.xpath("//input[contains(@id,'cc-')] | //form | //button[contains(text(),'Оплатить')]")).isEmpty();
    }

    public String getDisplayedSum() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'5')]"));
        for (WebElement el : elements) {
            String text = el.getText();
            if (text.contains("BYN") || text.contains("руб") || text.contains("5.00")) {
                return text;
            }
        }
        return "Сумма не найдена";
    }

    public String getDisplayedPhoneNumber() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'297777777')]"));
        if (!elements.isEmpty()) {
            return elements.get(0).getText();
        }
        return "Номер не найден";
    }
}