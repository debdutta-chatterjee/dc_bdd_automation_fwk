package com.pom.pages;

import com.factory.pom.PageObjectFactory;
import com.pom.components.SearchComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class StorePage extends BasePage
{
    public StorePage(WebDriver driver)
    {
        super(driver);
    }

    private String pageNav ="/store";
    private SearchComponent searchComponent = PageObjectFactory.getSearchComponent(driver);
    public void navigate()
    {
        super.navigate(pageNav);
    }

    @FindBy(css = "a[title='View cart']") private WebElement viewCartLink;
    @FindBy(xpath = "//h1[normalize-space()='Store']") private WebElement titleTxt;

    public void addToCart(String productName){
        wait.until(ExpectedConditions.visibilityOf(titleTxt));
        wait.until(ExpectedConditions.elementToBeClickable(this.arrToCartBtn(productName))).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }

    public SearchComponent getSearchComponent()
    {
        return searchComponent;
    }

    private By arrToCartBtn(String product)
    {
        return By.xpath("//a[contains(.,'"+product+"')]" +
                "/parent::div[@class='astra-shop-summary-wrap']//a[contains(.,'Add to cart')]");
    }
}
