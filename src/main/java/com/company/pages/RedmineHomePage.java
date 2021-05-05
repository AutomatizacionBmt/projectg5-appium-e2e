package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineHomePage extends RedmineLandingPage{

    private By lblUserLogged = By.id("loggedas");

    private By menuMobileEmulationUserLogged = By.xpath("//*[@id=\"wrapper\"]/div[1]/div[2]/a");

    private By menuMyProjects = By.xpath("//a[@href='/projects']");

    private By menuAdministration = By.xpath("//a[@href='/admin']");



    public RedmineHomePage(WebDriver driver) {
        super(driver);
    }

    public String getUserLogged(){
        return driver.findElement(lblUserLogged).getText();
    }

    public String getUserLoggedMobileEmulation(){
        return  driver.findElement(menuMobileEmulationUserLogged).getText();
    }

    /*public RedmineProjectsPage clickOnMenuProjects(){
        driver.findElement(menuMyProjects).click();
        return new RedmineProjectsPage(driver);
    }

    public RedmineUserPage clickOnMenuAdministration(){
        driver.findElement(menuAdministration).click();
        return  new RedmineUserPage(driver);
    }*/


}
