package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PaymentFramePage extends BasePage {

    public PaymentFramePage(WebDriver driver) {
        super(driver);
        // Переключаемся на iframe с формой оплаты
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[contains(@src, 'payment') or contains(@src, 'pay')]")
        ));
    }

    // === Элементы формы оплаты ===
    @FindBy(xpath = "//span[contains(@class, 'amount') or contains(@class, 'sum')]")
    private WebElement amountDisplay;

    @FindBy(xpath = "//button[contains(text(), 'Оплатить')]")
    private WebElement payButton;

    @FindBy(xpath = "//div[contains(@class, 'phone') or contains(@class, 'number')]")
    private WebElement phoneNumberDisplay;

    // Поля для реквизитов карты
    @FindBy(xpath = "//input[contains(@placeholder, 'Номер карты')]")
    private WebElement cardNumberField;

    @FindBy(xpath = "//input[contains(@placeholder, 'Срок') or contains(@placeholder, 'MM/ГГ')]")
    private WebElement expiryDateField;

    @FindBy(xpath = "//input[contains(@placeholder, 'CVC') or contains(@placeholder, 'CVV')]")
    private WebElement cvcField;

    @FindBy(xpath = "//input[contains(@placeholder, 'Имя') or contains(@placeholder, 'держателя')]")
    private WebElement cardholderNameField;

    // Иконки платёжных систем
    @FindBy(xpath = "//img[contains(@src, 'visa')]")
    private WebElement visaIcon;

    @FindBy(xpath = "//img[contains(@src, 'mastercard')]")
    private WebElement mastercardIcon;

    @FindBy(xpath = "//img[contains(@src, 'belkart')]")
    private WebElement belkartIcon;

    // === Методы для проверки ===

    public String getDisplayedAmount() {
        return wait.until(ExpectedConditions.visibilityOf(amountDisplay)).getText();
    }

    public String getPayButtonText() {
        return wait.until(ExpectedConditions.visibilityOf(payButton)).getText();
    }

    public String getDisplayedPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOf(phoneNumberDisplay)).getText();
    }

    public String getCardNumberFieldPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOf(cardNumberField)).getAttribute("placeholder");
    }

    public String getExpiryDateFieldPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOf(expiryDateField)).getAttribute("placeholder");
    }

    public String getCvcFieldPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOf(cvcField)).getAttribute("placeholder");
    }

    public String getCardholderNameFieldPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOf(cardholderNameField)).getAttribute("placeholder");
    }

    public boolean arePaymentSystemIconsDisplayed() {
        try {
            return visaIcon.isDisplayed() && mastercardIcon.isDisplayed() && belkartIcon.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPaymentFormDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(payButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}