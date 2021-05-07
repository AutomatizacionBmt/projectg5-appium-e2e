package com.company.features;

import com.company.base.BaseTest;
import com.company.pages.AndroidCalculatorPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidEmulatorCalculatorNativeUITest extends BaseTest {

    private AndroidCalculatorPage androidCalculatorPage;

    @Test
    public void testCalculatorCalculatePlusTwoNumbersNexusAndroid7(){

        configCapabilitiesNexusAndroid5Android7();

        androidCalculatorPage = new AndroidCalculatorPage(driver);
        androidCalculatorPage.calculate("1570", "750","plus");

        Assert.assertEquals("La suma es incorrecta",
                "2320",
                androidCalculatorPage.getResult());

    }


    @Test
    public void testCalculatorCalculateSubtractionTwoNumbersNexusAndroid7(){

        configCapabilitiesNexusAndroid5Android7();

        androidCalculatorPage = new AndroidCalculatorPage(driver);
        androidCalculatorPage.calculate("120", "12","subtraction");

        Assert.assertEquals("La resta es incorrecta",
                "108",
                androidCalculatorPage.getResult());

    }

    @Test
    public void testCalculatorCalculateMultiplicationTwoNumbersNexusAndroid7(){

        configCapabilitiesNexusAndroid5Android7();

        androidCalculatorPage = new AndroidCalculatorPage(driver);
        androidCalculatorPage.calculate("2500", "5","multiplication");

        Assert.assertEquals("La multiplicación es incorrecta",
                "12500",
                androidCalculatorPage.getResult());

    }

    @Test
    public void testCalculatorCalculateDivisionTwoNumbersNexusAndroid7(){

        configCapabilitiesNexusAndroid5Android7();

        androidCalculatorPage = new AndroidCalculatorPage(driver);
        androidCalculatorPage.calculate("120000", "16","division");

        Assert.assertEquals("La división es incorrecta",
                "7500",
                androidCalculatorPage.getResult());

    }



    private void configCapabilitiesNexusAndroid5Android7() {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","7.0");
        cap.setCapability("avd", "Nexus5Android7");
        cap.setCapability("deviceName", "Nexus5Android7");
        cap.setCapability("avdArgs", "-port 5557");

        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("appWaitActivity", "com.android.calculator2.Calculator");

        configAppiumDriver(cap);

    }

}
