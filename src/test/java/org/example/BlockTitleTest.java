package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlockTitleTest extends MtsBaseTest {

    @Test(priority = 1)
    public void testBlockTitle() {
        boolean found = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.tagName("body"), "Онлайн пополнение"
        ));
        Assert.assertTrue(found, "Текст 'Онлайн пополнение' не найден на странице");
    }
}