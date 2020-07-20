package com.wb3tech.test_framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "B:\\1-devtools\\testing-tools\\google-chrome\\chromedriver.exe");
        var options = new ChromeOptions().addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
