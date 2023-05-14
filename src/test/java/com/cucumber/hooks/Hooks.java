package com.cucumber.hooks;

import com.factory.driver.WebdriverFactory;
import io.cucumber.java.*;
import com.contexts.TestContext;
import org.openqa.selenium.WebDriver;

public class Hooks
{
    private TestContext context;
    private WebDriver driver;

    public Hooks(TestContext context)
    {
        this.context = context;
    }

    @BeforeAll
    public static void beforeAll()
    {

    }

    @AfterAll
    public static void afterAll()
    {

    }

    @Before
    public void initialize(Scenario scenario)
    {
        System.out.println("Thread Id::"+ Thread.currentThread().getId());
        System.out.println("Scenario Name::"+ scenario.getName());
        driver = WebdriverFactory.getDriver(System.getProperty("browser","chrome"));
        context.setDriver(driver);
    }

    @After
    public void cleanup(Scenario scenario)
    {
        System.out.println("Thread Id::"+ Thread.currentThread().getId());
        System.out.println("Scenario Name::"+ scenario.getName());
        context.getDriver().quit();
    }
}

