package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Datadriven {
    public static WebDriver driver;
    @Given("user has a login page with url.")
    public void user_has_a_login_page_with_url() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
    }
    @When("user enter the credential with {string} and {string}.")
    public void user_enter_the_credential_with_and(String string, String string2) {
        driver.findElement(By.id("user-name")).sendKeys(string);
        driver.findElement(By.id("password")).sendKeys(string2);
        driver.findElement(By.id("login-button")).click();
    }
    @Then("Successfully login in the application.")
    public void successfully_login_in_the_application() {
        System.out.println("Login Successfully");
    }
}
