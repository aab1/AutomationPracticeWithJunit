package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.util.ElementUtil;

public class LoginPage extends ElementUtil {

    private WebDriver driver;

    // 1. By Locators: OR
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.linkText("Forgot your password?");

    // 2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }
/*
* Assertions should be written in the test classes and not in page class
* I can also create waitTime in config properties and create explicit
* wait in the constructor for each page or keep it in the util class
*/
    public AccountsPage doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }

}
