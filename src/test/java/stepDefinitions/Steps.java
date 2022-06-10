package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    public static WebDriver driver;

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {


        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
    }


    @When("User enters {string} and {string}")
    public void user_enters_and(String string, String string2) {

        driver.findElement(By.id("user-name")).sendKeys(string);
        driver.findElement(By.id("password")).sendKeys(string2);
        driver.findElement(By.id("login-button")).click();

    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully() throws Throwable {
        System.out.println("Login Successfully");
    }
    @Then("Select the item.")
    public void select_the_item() {
        driver.findElement(By.xpath("//div[text()=\"Sauce Labs Backpack\"]")).click();
    }

    @Then("click on Add to cart icon.")
    public void click_on_add_to_cart_icon() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Click on checkout icon.")
    public void click_on_checkout_icon() {
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
    }

    @Then("Checkout the item.")
    public void checkout_the_item() {
        driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
    }


    @Then("Enter the {string},{string} and {string}.")
    public void enter_the_and(String string, String string2, String string3) {

        driver.findElement(By.id("first-name")).sendKeys(string);
        driver.findElement(By.id("last-name")).sendKeys(string2);
        driver.findElement(By.id("postal-code")).sendKeys(string3);

    }
    @Then("Click on Continue.")
    public void click_on_continue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("Validate the details.")
    public void validate_the_details() {
        WebElement p = driver.findElement(By.xpath("//div[text()=\"Sauce Labs Backpack\"]"));
        String text = p.getText();
        Assert.assertEquals("Sauce Labs Backpack",text);
    }

    @Then("Click on Finish button.")
    public void click_on_finish_button() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("Verify the order dispatch message.")
    public void verify_the_order_dispatch_message() {
        WebElement p1 = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        String ss = p1.getText();
        String actualtext = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actualtext,ss);
    }

    @Then("Click on Back home button.")
    public void click_on_back_home_button() {
        driver.findElement(By.xpath(" //button[text()=\"Back Home\"]")).click();

    }

    @Then("close the browser.")
    public void close_the_browser() {
        driver.close();









    }


}
