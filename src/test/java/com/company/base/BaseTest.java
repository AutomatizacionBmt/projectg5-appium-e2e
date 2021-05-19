package com.company.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.AfterClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static AppiumDriver driver;

    public static void configAppiumDriver(DesiredCapabilities capabilities) {

        String platformName = System.getenv("platformName");
        platformName = (platformName == null) ? "android" : platformName.toLowerCase();

        try {

            switch (platformName) {

                case "android":
                    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
                    break;
                case "ios":
                    driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
                    break;
                default:
                    throw new IllegalStateException("The platformName " + platformName +
                            " option is not present");
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


}
