package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/feature_files",
        glue = {"com.stepDef","com.cucumber.hooks","com.cucumber.customTypes"},
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json"},
        monochrome = true,
        dryRun = false,
        tags = "@Test" //"@smoke and @Regression"
)
public class TestngRunnerTest extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
       return super.scenarios();
    }
}
