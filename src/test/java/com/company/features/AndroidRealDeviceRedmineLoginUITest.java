package com.company.features;

import com.company.base.BaseTest;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLandingPage;
import com.company.pages.RedmineLoginPage;
import com.company.utils.Urls;
import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidRealDeviceRedmineLoginUITest extends BaseTest {



    @Test
    public void testLoginRedmineRealDeviceNexusLGXMaxAndroid6(){

          /* Consideraciones
        1.- Requisito: Activar las opciones para desarrolladores y la depuración por usb en el
        dispositivo real.
        2.- Descargar el chromedriver para la versión correcta de nuestro chrome de nuestro dispositivo móvil.
        3.- Identificar el "udid" correcto, conectando con un cable usb Movil - COmputadora ; luego ejecutar comando:
        en la terminal : adb devices .
        */

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","7.0");
        cap.setCapability("udid", "LGK240IN9HSGHA");
        cap.setCapability("deviceName", "LG X Max");
        cap.setCapability("avdArgs", "-port 5557");

        cap.setCapability("browserName", "chrome");

        //Para Windows
        /*cap.setCapability("chromedriverExecutableDir",
                "/Users/jhumbertoh/Proyectos/Publicos/projectg5-appium-e2e/resources/drivers/chrome/windows");*/

        //Para MAC
        cap.setCapability("chromedriverExecutableDir",
                "/Users/jhumbertoh/Proyectos/Publicos/projectg5-appium-e2e/resources/drivers/chrome/mac");


        cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

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
