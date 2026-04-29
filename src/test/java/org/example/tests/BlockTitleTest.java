package org.example.tests;

import base.MtsBaseTest;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlockTitleTest extends MtsBaseTest {

    @Test
    public void testBlockTitle() {
        HomePage homePage = new HomePage(driver);
        String title = homePage.getBlockTitle();
        System.out.println("Заголовок блока: " + title);
        Assert.assertTrue(title.contains("Онлайн пополнение"),
                "Заголовок блока не содержит 'Онлайн пополнение'");
    }
}