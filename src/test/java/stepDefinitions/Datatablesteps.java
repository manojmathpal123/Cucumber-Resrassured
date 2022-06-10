package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Datatablesteps {


    public static WebDriver driver;

    @Given("login to Home Page")
    public void login_to_home_page() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
    }
    @When("entering username and password in the application,")
    public void entering_username_and_password_in_the_application(DataTable dataTable) {
        List<Map<String,String>> userlist =dataTable.asMaps(String.class, String.class);
        for(Map<String,String> e : userlist)
        {
            driver.findElement(By.id("user-name")).sendKeys(e.get("usrname"));
            driver.findElement(By.id("password")).sendKeys(e.get("password"));
            driver.findElement(By.id("login-button")).click();
        }

    }
    @Then("Message showing Login Successfully in the application")
    public void message_showing_login_successfully_in_the_application() {
        System.out.println("Login Successfully");
    }
    @Then("Item select.")
    public void item_select() {
        driver.findElement(By.xpath("//div[text()=\"Sauce Labs Backpack\"]")).click();
    }
    @Then("Add to cart icon.")
    public void add_to_cart_icon() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    @Then("checkout icon.")
    public void checkout_icon() {
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
    }
    @Then("Checkout the item which we selected.")
    public void checkout_the_item_which_we_selected() {
        driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
    }
    @Then("Entering  all firstname,lastname and pincode in page.")
    public void entering_all_firstname_lastname_and_pincode_in_page(DataTable dataTable) {
        List<Map<String,String>> userlist =dataTable.asMaps(String.class, String.class);
        for(Map<String,String> e : userlist)
        {
            driver.findElement(By.id("first-name")).sendKeys(e.get("firstname"));
            driver.findElement(By.id("last-name")).sendKeys(e.get("lastname"));
            driver.findElement(By.id("postal-code")).sendKeys(e.get("pincode"));
        }
    }
    @Then("Continue button click.")
    public void continue_button_click() {
        driver.findElement(By.id("continue")).click();
    }
    @Then("Verify and validate the details of application.")
    public void verify_and_validate_the_details_of_application() {
        WebElement p = driver.findElement(By.xpath("//div[text()=\"Sauce Labs Backpack\"]"));
        String text = p.getText();
        Assert.assertEquals("Sauce Labs Backpack", text);
    }
    @Then("Finish button click.")
    public void finish_button_click() {
        driver.findElement(By.id("finish")).click();
    }
    @Then("Validate order dispatch message in page.")
    public void validate_order_dispatch_message_in_page() {
        WebElement p1 = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        String ss = p1.getText();
        String actualtext = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actualtext, ss);
    }
    @Then("Back home button click.")
    public void back_home_button_click() {
        driver.findElement(By.xpath(" //button[text()=\"Back Home\"]")).click();
    }
    @Then("browser closing.")
    public void browser_closing() {
       driver.close();
    }



}
