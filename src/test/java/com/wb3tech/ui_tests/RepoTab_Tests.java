package com.wb3tech.ui_tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepoTab_Tests extends SeleniumUITest {
    @Test
    void repositoryCountIsCorrect() {

        // Arrange

        // Act
        driver.get("https://github.com/BillBensing?tab=repositories");

        var repolist = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        // Assert
        assertEquals(15, repolist.size());

    }

}
