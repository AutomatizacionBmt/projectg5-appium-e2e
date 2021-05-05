package com.company.base;

import io.appium.java_client.AppiumDriver;
import org.junit.AfterClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static AppiumDriver driver;

    public static void configAppiumDriver(DesiredCapabilities capabilities){

        try {
            driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"),capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


}
