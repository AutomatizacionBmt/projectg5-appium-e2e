package com.company.features;

import com.company.base.BaseTest;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLandingPage;
import com.company.pages.RedmineLoginPage;
import com.company.utils.Urls;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidEmulatorRedmineLoginUITest extends BaseTest {



    @Test
    public void testLoginRedmineEmulatorNexusAndroid7(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","7.0");
        cap.setCapability("avd", "Nexus5Android7");
        cap.setCapability("deviceName", "Nexus5Android7");
        cap.setCapability("avdArgs", "-port 5557");

        cap.setCapability("browserName", "chrome");

        //Para Windows
        /*cap.setCapability("chromedriverExecutableDir",
                "/Users/jhumbertoh/Proyectos/Publicos/projectg5-appium-e2e/resources/drivers/chrome/windows");*/

        //Para MAC
        cap.setCapability("chromedriverExecutableDir",
                "/Users/jhumbertoh/Proyectos/Publicos/projectg5-appium-e2e/resources/drivers/chrome/mac");


        configAppiumDriver(cap);

        driver.get(Urls.REDMINE_URL_LOCAL);

        RedmineLandingPage redmineLandingPage = new RedmineLandingPage(driver);
        redmineLandingPage.clickOnMobileMenu();


        RedmineLoginPage redmineLoginPage = redmineLandingPage.clickLinkLogin();

        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");

        redmineLandingPage.clickOnMobileMenu();

        String expectedUser = "user";
        String actualUser = redmineHomePage.getUserLoggedMobileEmulation();

        Assert.assertEquals("Login fallido",
                expectedUser,
                actualUser);
    }


}
