package com.wb3tech.ui_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverviewTab_Tests extends SeleniumUITest {

    String user = "BillBensing";

    @BeforeEach
    void overviewTabSetup() {
        driver.get(BASE_URL + user);
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {

        //Arrange
        // Act
        var actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(user, actualUserName);

    }

    @Test
    void repoLinkGoesToCorrectRepo() {

        //Arrange
        // Act
        var repo = "Angular2-Webpack-Starter";
        var repoLink = driver.findElement(By.linkText(repo));

        repoLink.click();

        var currentUrl = driver.getCurrentUrl();

        // Assert
        assertEquals("https://github.com/BillBensing/Angular2-Webpack-Starter", currentUrl);
    }

}
