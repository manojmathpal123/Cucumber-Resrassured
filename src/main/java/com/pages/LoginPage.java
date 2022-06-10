package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver Idriver;


    public LoginPage(WebDriver Rdriver) {
        Idriver = Rdriver;
        PageFactory.initElements(Rdriver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginbutton;

    public void setUsername(String uname)
    {
        username.clear();
        username.sendKeys(uname);
    }

    public void setpassword(String pwd)
    {
        password.clear();
        password.sendKeys(pwd);
    }

    public void clicklogin()
    {
        loginbutton.click();
    }

}
