package org.hquijano.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/org/hquijano/features",
        glue = "org.hquijano.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        tags = "@smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
