package stepDefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Pomlogin {

    private LoginPage loginPage = new LoginPage(DriverFactory.getdriver());
    @Given("Pom User is on login Page")
    public void pom_user_is_on_login_page() {
     DriverFactory.getdriver().get("https://www.saucedemo.com");
    }
    @When("user verify the data with sheetname {string} and rownumber {int}.")
    public void user_verify_the_data_with_sheetname_and_rownumber(String sheetName, Integer rowNum) throws IOException, InvalidFormatException {


        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData("/home/manoj/Documents/demo.xlsx", sheetName);
        String username = testdata.get(rowNum).get("usrname");
        String password = testdata.get(rowNum).get("password");
        String firstname = testdata.get(rowNum).get("firstname");
        String lastname = testdata.get(rowNum).get("lastname");
        String pincode = testdata.get(rowNum).get("pincode");

        System.out.println(username);
        System.out.println(password);
        loginPage.setUsername(username);
        loginPage.setpassword(password);
        loginPage.clicklogin();

    }
    @Then("displayed message Login Successfully")
    public void displayed_message_login_successfully() {
        System.out.println("successfully login");
    }

    @Then("close browsing window.")
    public void close_browsing_window() {
        DriverFactory.getdriver().close();
    }

}
