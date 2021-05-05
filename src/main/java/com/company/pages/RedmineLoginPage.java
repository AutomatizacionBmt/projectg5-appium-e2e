package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RedmineLoginPage extends RedmineLandingPage{

    private By txtUsername = By.id("username");
    private By txtPassword = By.name("password");
    private By btnLogin = By.xpath("//*[@id=\"login-submit\"]");


    public RedmineLoginPage(WebDriver driver) {
        super(driver);
    }

    public RedmineHomePage login (String user, String password){

        driver.findElement(txtUsername).sendKeys(user);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();

        return new RedmineHomePage(driver);
    }

    public RedmineHomePage loginWithEnter(String userName, String password){

        driver.findElement(txtUsername).sendKeys(userName);
        driver.findElement(txtPassword).sendKeys(password + Keys.ENTER);

        return  new RedmineHomePage(driver);
    }

}
