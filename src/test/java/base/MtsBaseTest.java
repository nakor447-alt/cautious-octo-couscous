package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Collections;

public class MtsBaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Отключаем автоматизацию
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Реалистичный User-Agent
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

        // Дополнительные настройки
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        loadSiteWithRetry();
        acceptCookies();
    }

    private void loadSiteWithRetry() {
        for (int i = 0; i < 3; i++) {
            try {
                driver.get("https://www.mts.by");
                System.out.println("Сайт загружен успешно");
                Thread.sleep(3000);
                return;
            } catch (Exception e) {
                System.out.println("Попытка " + (i + 1) + " не удалась");
                try { Thread.sleep(2000); } catch (Exception ex) {}
            }
        }
        System.out.println("Сайт не загрузился, но тест продолжается");
    }

    private void acceptCookies() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Принять')] | " +
                            "//button[contains(text(),'Согласен')] | " +
                            "//button[contains(text(),'ОК')]")
            ));
            btn.click();
            System.out.println("Cookies приняты");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Окно cookies не найдено");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}