package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedmineLandingPage {

    protected WebDriver driver;

    private By linkLogin = By.cssSelector("a.login");

    private By menuMobileEmulationMenuButton = By.cssSelector("#header > a");

    public RedmineLandingPage(WebDriver driver){
        this.driver = driver;
    }

    public RedmineLoginPage clickLinkLogin(){

        driver.findElement(linkLogin).click();

        return new RedmineLoginPage(driver);
    }

    public void clickOnMobileMenu(){

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(menuMobileEmulationMenuButton));
        driver.findElement(menuMobileEmulationMenuButton).click();
    }

}
