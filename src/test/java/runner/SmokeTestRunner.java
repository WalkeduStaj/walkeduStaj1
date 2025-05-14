package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/smoke/cucumber-pretty.html",
        "json:target/cucumber-reports/smoke/cucumber.json",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"

    },

    tags = "@smokeinstructorlogin",
    monochrome = false
)
public class SmokeTestRunner {
} 