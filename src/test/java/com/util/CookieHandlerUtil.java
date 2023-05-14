package com.util;

import io.restassured.http.Cookies;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class CookieHandlerUtil
{
    private io.restassured.http.Cookies cookies;

    public void injectCookiesToBrowser(WebDriver driver){
        List<org.openqa.selenium.Cookie> seleniumCookies = convertToWebDriverCookie(cookies);
        int i = 0;
        for(org.openqa.selenium.Cookie cookie: seleniumCookies){
            System.out.println("COUNTER " + i + ": " + cookie.toString());
            driver.manage().addCookie(cookie);
            i++;
        }
        driver.navigate().refresh();
    }

    private static List<org.openqa.selenium.Cookie>  convertToWebDriverCookie(Cookies cookies){
        List<io.restassured.http.Cookie> restAssuredCookies;
        restAssuredCookies = cookies.asList();
        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();
        for(io.restassured.http.Cookie cookie: restAssuredCookies){
            seleniumCookies.add(new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(),
                    cookie.getPath(), cookie.getExpiryDate(), cookie.isSecured(), cookie.isHttpOnly(),
                    cookie.getSameSite()));
        }
        return seleniumCookies;
    }
}
