package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "/home/manoj/IdeaProjects/HCLSDET/src/test/java/Features",
                glue = {"stepDefinitions","HclHooks"},
                tags = "@sanity",
                plugin = {"pretty","html:target/cucumber-html-report",
                        "json:target/cucumber-reports/cucumber.json",
                        "junit:target/cucumber-reports/cucumber.xml",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                        "timeline:test-output-thread/",
                        "rerun:target/failedrerun.txt"

                },
                publish = true
                )
public class TestRun  {
}
