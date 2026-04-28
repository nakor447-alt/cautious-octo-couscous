package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    private final WebDriverWait shortWait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // === Элементы блока "Онлайн пополнение" ===
    @FindBy(xpath = "//*[contains(text(), 'Онлайн пополнение')]")
    private WebElement onlinePaymentTitle;

    @FindBy(xpath = "//div[contains(@class, 'pay')]//img[contains(@src, 'mastercard')]")
    private WebElement mastercardLogo;

    @FindBy(xpath = "//div[contains(@class, 'pay')]//img[contains(@src, 'visa')]")
    private WebElement visaLogo;

    @FindBy(xpath = "//a[contains(@href, 'help')]")
    private WebElement moreDetailsLink;

    // === Вкладки услуг ===
    @FindBy(xpath = "//*[contains(text(), 'Услуги связи')]")
    private WebElement communicationServiceTab;

    @FindBy(xpath = "//*[contains(text(), 'Домашний интернет')]")
    private WebElement homeInternetTab;

    @FindBy(xpath = "//*[contains(text(), 'Рассрочка')]")
    private WebElement installmentTab;

    @FindBy(xpath = "//*[contains(text(), 'Задолженность')]")
    private WebElement debtTab;

    // === Поля ввода ===
    @FindBy(xpath = "//input[contains(@placeholder, 'Номер') or contains(@placeholder, 'телефон')]")
    private WebElement phoneField;

    @FindBy(xpath = "//input[contains(@placeholder, 'Сумма')]")
    private WebElement amountField;

    // === Кнопка продолжения ===
    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    // === Список всех вкладок для проверки placeholder'ов ===
    private List<WebElement> getServiceTabs() {
        return List.of(communicationServiceTab, homeInternetTab, installmentTab, debtTab);
    }

    // === Методы ===

    public boolean isOnlinePaymentBlockDisplayed() {
        return shortWait.until(ExpectedConditions.visibilityOf(onlinePaymentTitle)).isDisplayed();
    }

    public boolean arePaymentLogosDisplayed() {
        return mastercardLogo.isDisplayed() && visaLogo.isDisplayed();
    }

    public void clickMoreDetailsLink() {
        scrollToElement(moreDetailsLink);
        clickWithJS(moreDetailsLink);
    }

    public void selectCommunicationService() {
        wait.until(ExpectedConditions.elementToBeClickable(communicationServiceTab)).click();
    }

    public void selectHomeInternetTab() {
        wait.until(ExpectedConditions.elementToBeClickable(homeInternetTab)).click();
    }

    public void selectInstallmentTab() {
        wait.until(ExpectedConditions.elementToBeClickable(installmentTab)).click();
    }

    public void selectDebtTab() {
        wait.until(ExpectedConditions.elementToBeClickable(debtTab)).click();
    }

    public String getPhoneFieldPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOf(phoneField)).getAttribute("placeholder");
    }

    public String getAmountFieldPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOf(amountField)).getAttribute("placeholder");
    }

    public void enterPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneField)).sendKeys(phone);
    }

    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOf(amountField)).sendKeys(amount);
    }

    public PaymentFramePage clickContinue() {
        scrollToElement(continueButton);
        clickWithJS(continueButton);
        return new PaymentFramePage(driver);
    }

    public void checkAllTabsPlaceholders() {
        for (WebElement tab : getServiceTabs()) {
            tab.click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Плейсхолдер для вкладки '" + tab.getText() + "': телефон - " + getPhoneFieldPlaceholder());
        }
        selectCommunicationService();
    }
}