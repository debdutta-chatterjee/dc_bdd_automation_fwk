package com.factory.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory
{
    private static WebDriver driver;

    public static WebDriver createDriver()
    {
        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver createDriver(FirefoxOptions options)
    {
        driver = new FirefoxDriver(options);
        return driver;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public void quitDriver()
    {
        driver.quit();
    }
}
