package com.factory.pom;

import com.pom.components.SearchComponent;
import com.pom.pages.CartPage;
import com.pom.pages.CheckoutPage;
import com.pom.pages.StorePage;
import org.openqa.selenium.WebDriver;

public class PageObjectFactory
{
    private static StorePage storepage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;
    private static SearchComponent searchComponent;

    public static StorePage getStorePage(WebDriver driver)
    {
        return storepage == null ?  new StorePage(driver) :  storepage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver)
    {
        return checkoutPage == null ?  new CheckoutPage(driver) :  checkoutPage;
    }

    public static CartPage getCartPage(WebDriver driver)
    {
        return cartPage == null ?  new CartPage(driver) :  cartPage;
    }

    public static SearchComponent getSearchComponent(WebDriver driver)
    {
        return searchComponent == null ?  new SearchComponent(driver) :  searchComponent;
    }
}
