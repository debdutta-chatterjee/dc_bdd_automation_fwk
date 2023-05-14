package com.pom.pages;

import com.constants.ProjectConstants;
import com.util.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage
{
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String baseUrl = ConfigLoader.getInstance().getBaseUrl();

    protected BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ProjectConstants.DEFAULTTIMEOUT));
        PageFactory.initElements(driver,this);
    }

    protected void navigate(String pageNav)
    {
        driver.get(baseUrl+pageNav);
    }

}
