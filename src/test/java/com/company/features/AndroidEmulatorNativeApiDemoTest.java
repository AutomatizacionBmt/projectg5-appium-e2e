package com.company.features;

import com.company.base.BaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AndroidEmulatorNativeApiDemoTest extends BaseTest {

    @Test
    public void testTouchActionNexusAndroid7(){


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","7.0");
        cap.setCapability("avd", "Nexus5Android7");
        cap.setCapability("deviceName", "Nexus5Android7");
        cap.setCapability("avdArgs", "-port 5557");

        cap.setCapability("app",
                "/Users/jhumbertoh/Proyectos/Publicos/projectg5-appium-e2e/resources/apks/ApiDemos-debug.apk");

        configAppiumDriver(cap);

        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();

        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]");

        TouchAction touch = new TouchAction(driver);
        ElementOption elementOption = element(expandList);
        TapOptions tapOptions = tapOptions().withElement(elementOption);

        touch.tap(tapOptions).perform();

        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]").click();

        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");


        /* ElementOption elementOption2 = element(peopleNames);
        LongPressOptions longPressOptions = longPressOptions().withElement(elementOption2).withDuration(Duration.ofSeconds(2));

        touch.longPress(longPressOptions).release().perform();*/

        touch.
                longPress(longPressOptions().
                        withElement(element(peopleNames)).
                        withDuration(Duration.ofSeconds(2))).
                release().
                perform();


        List<WebElement> listTitles = driver.findElementsById("android:id/title");

        Assert.assertTrue(listTitles.get(1).isDisplayed());

        //Hola Johana

    }
}
