package com.stepDef;

import com.apis.service.CartApi;
import com.contexts.TestContext;
import com.factory.pom.PageObjectFactory;
import com.pojo.objects.Product;
import com.pom.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class StorePageStepDef
{
    private final StorePage storePage;
    private final TestContext context;

    public StorePageStepDef(TestContext context){
        this.context = context;
        storePage = PageObjectFactory.getStorePage(context.driver);
    }

    @Given("I am on the {string}")
    public void i_am_on_the_section(String sectionName,DataTable dataTable) {
        System.out.println(String.format("I am on the %s <Section>",sectionName));
    }
    @When("I search {string}")
    public void i_search(String product) {
        System.out.println(String.format("I am on the %s <Section>",product));
    }
    @Then("I can see the {string}")
    public void i_can_see_the(String product) {
        System.out.println(String.format("I am on the %s <Section>",product));
    }

    @Given("I'm/I_am on the Store Page/tab")
    public void i_am_on_the_store_page()
    {
        storePage.navigate();
    }

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        storePage.addToCart(product.getName());
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215, 1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
    }

}
