package com.factory.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory
{
    private static WebDriver driver;

    public static WebDriver createDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver createDriver(ChromeOptions options)
    {
        driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void quitDriver()
    {
        driver.quit();
    }
}
