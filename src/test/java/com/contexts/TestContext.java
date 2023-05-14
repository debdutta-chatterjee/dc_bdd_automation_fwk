package com.contexts;

import com.pojo.objects.BillingDetails;
import com.util.CookieHandlerUtil;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class TestContext
{
    public WebDriver driver;
    public BillingDetails billingDetails;
    public CookieHandlerUtil cookies;

    public TestContext()
    {
        cookies = new CookieHandlerUtil();
        cookies.setCookies(new io.restassured.http.Cookies());
    }
}
