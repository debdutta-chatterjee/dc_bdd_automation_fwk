package com.pom.components;

import com.pom.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends BasePage
{
    @FindBy(css="input.search-field")
    private WebElement searchTextbox;

    @FindBy(css="button[value='Search']")
    private WebElement searchButton;

    public SearchComponent(WebDriver driver) {
        super(driver);
    }

    public SearchComponent searchProduct(String productName)
    {
        wait.until(d -> searchTextbox.isDisplayed());
        searchTextbox.sendKeys(productName);
        searchButton.click();
        return this;
    }
}
