package com.company.features;

import com.company.base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidEmulatorChrome extends BaseTest {


    @Test
    public void testOpenChromeEmulatorNexus5Android7(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","7.0");
        cap.setCapability("avd", "Nexus5Android7");
        cap.setCapability("deviceName", "Nexus5Android7");
        cap.setCapability("avdArgs", "-port 5557");

        cap.setCapability("browserName", "chrome");

        //Para Windows
        cap.setCapability("chromedriverExecutableDir",
                "/Users/jhumbertoh/Proyectos/Publicos/projectg5-appium-e2e/resources/drivers/chrome/windows");

        //Para MAC
        /*cap.setCapability("chromedriverExecutableDir",
                "/Users/jhumbertoh/Proyectos/Publicos/projectg5-appium-e2e/resources/drivers/chrome/mac");*/



        configAppiumDriver(cap);

    }
}
