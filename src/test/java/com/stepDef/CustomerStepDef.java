package com.stepDef;

import com.contexts.TestContext;
import com.factory.pom.PageObjectFactory;
import com.pom.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.pojo.objects.BillingDetails;

public class CustomerStepDef {
    private final TestContext context;
    private final StorePage storePage;

    public CustomerStepDef(TestContext context){
        this.context = context;
        storePage = PageObjectFactory.getStorePage(context.driver);
    }

    @And("My billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

    @Given("I'm/I am a guest customer")
    public void iMAGuestCustomer() {
        storePage.navigate();
    }
}
