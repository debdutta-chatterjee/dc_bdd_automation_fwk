package com.stepDef;

import com.contexts.TestContext;
import com.factory.pom.PageObjectFactory;
import com.pom.pages.CartPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import com.pojo.objects.Product;

public class CartStepDef {
    private final CartPage cartPage;

    public CartStepDef(TestContext context){
        cartPage = PageObjectFactory.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}
