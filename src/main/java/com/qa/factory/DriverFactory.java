package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser)
    {

        if(browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tldriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tldriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            WebDriverManager.iedriver().setup();
            tldriver.set(new InternetExplorerDriver());

        }
        else
        {
            System.out.println("please pass the correct browser value" + browser);
        }
        getdriver().manage().deleteAllCookies();
        getdriver().manage().window().maximize();
        return getdriver();
    }


    public static synchronized WebDriver getdriver()
    {
        return tldriver.get();
    }
}
