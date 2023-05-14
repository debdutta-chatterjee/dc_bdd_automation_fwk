package com.factory.driver;

import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.function.Supplier;

public class WebdriverFactory
{
    private static Supplier<WebDriver> chromeDriver = () -> ChromeDriverFactory.createDriver();
    private static Supplier<WebDriver> firefoxDriver = () -> FirefoxDriverFactory.createDriver();

    private static Map<String, Supplier<WebDriver>> driverMap = Map.of(
            "chrome", chromeDriver,
            "firefox", firefoxDriver
    );

    public static WebDriver getDriver(String driverName)
    {
        return driverMap.get(driverName).get();
    }
}
