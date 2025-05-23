package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },


        tags = "@smokeinstructor:",
        dryRun = false //'dryRun = true' testi çalıştırmaz, eksik step deinitionları bulur.


)
public class TestRunner {
} 