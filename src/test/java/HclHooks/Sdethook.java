package HclHooks;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Sdethook {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before("@Smoke")
    public void setupbrowser(Scenario scenario)
    {
        System.out.println(scenario.getName());
        System.out.println("login succesfully in HCL");
    }
    @After("@Smoke")
    public void logout()
    {
        System.out.println("logout succesfully");
    }


    @Before("@Smoke")
    public void getProperty()
    {
        configReader  = new ConfigReader();
        prop = configReader.init_prop();

    }
    @Before("@Smoke")
    public void launchbrowser()
    {
        String browsername = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driverFactory.init_driver(browsername);
    }
    @After("@Smoke")
    public void teardown(Scenario sc)
    {
        if(sc.isFailed())
        {
            String screenshotname = sc.getName().replaceAll(" ","_");
            byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcepath,"image/png",screenshotname);


        }
    }


}
