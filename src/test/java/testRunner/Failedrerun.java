package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                plugin = {"pretty","html:target/cucumber-html-report",
                        "json:target/cucumber-reports/cucumber.json",
                        "junit:target/cucumber-reports/cucumber.xml",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                        "timeline:test-output-thread/",
                        "rerun:target/failedrerun.txt"

                },
                features = "@target/failedrerun.txt",
                glue = {"stepDefinitions","HclHooks"},
                tags = "@Prod",

                publish = true
        )

public class Failedrerun {
}
