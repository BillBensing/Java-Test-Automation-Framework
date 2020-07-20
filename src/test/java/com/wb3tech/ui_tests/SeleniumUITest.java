package com.wb3tech.ui_tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import static com.wb3tech.test_framework.DriverFactory.getChromeDriver;

public class SeleniumUITest {

    protected static final String BASE_URL = "https://github.com/";
    protected static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = getChromeDriver();
    }

    @AfterAll
    static void cleanUp() {
        driver.close();
    }

}
