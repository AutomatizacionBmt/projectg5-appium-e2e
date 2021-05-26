package com.company.features;

import com.company.base.BaseTest;
import com.company.pages.IOSReminderPage;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class IOSSimulatorNativeUITest extends BaseTest {

    //Consideraciones

    //.app(Simulators IOS) ; .ipa( Dispositivo real IOS)

    //Para Automatizar en Mac:
    // 1.- Xcode (desde el app store o desde la web apple developer);
    // 2.- ComandLineTools (https://developer.apple.com/download/more/?=command%20line%20tools);
    // 3.- Cocoapods (https://cocoapods.org);
    // 4.- Carthage (https://github.com/Carthage/Carthage) -> brew install carthage

    //Install Brew: Install gestos de paquetes para mac : https://brew.sh/index_es

    //Luego ejecutar desde la terminal : appium-doctor --ios
    //Debe estar todo OK

    //Automatizacion en IOS Real Devices:
    //http://appium.io/docs/en/drivers/ios-xcuitest-real-devices/
    //MEmbresia de IOS Developer= https://developer.apple.com/es/support/compare-memberships/

    @Test
    public void testOpenUIKitCatalogSimulatorIphone11ProMax(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "XCuiTest");
        cap.setCapability("platformName","IOS");
        cap.setCapability("platformVersion","14.4");
        cap.setCapability("deviceName", "iPhone 11 Pro Max");

        cap.setCapability("noReset", true);
        cap.setCapability("useNewWDA", false);
        cap.setCapability("fullReset", false);
        cap.setCapability("startIWDP", true);

        cap.setCapability("newCommandTimeout", "200");
        cap.setCapability("app", "/Users/jhumbertoh/Proyectos/Publicos/projectg5-appium-e2e/resources/apps/UIKitCatalog.app");

        configAppiumDriver(cap);



    }

    //Establecer la variable de entorno "platformName" a "ios"
    @Test
    public void testCreateReminderIphone6sPlus() {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "XCuiTest");
        cap.setCapability("platformName", "IOS");
        cap.setCapability("platformVersion", "12.0");
        cap.setCapability("deviceName", "iPhone 6s Plus");

        //Only real devices
        //cap.setCapability("webkitDebugProxyPort", 27754);
        //cap.setCapability("wdaLocalPort", 8102);
        //cap.setCapability("xcodeOrgId", "X3NTAA9PV");
        //cap.setCapability("xcodeSigningId", "iPhone Developer");

        cap.setCapability("noReset", true);
        cap.setCapability("useNewWDA", false);
        cap.setCapability("fullReset", false);
        cap.setCapability("startIWDP", true);

        cap.setCapability("bundleId", "com.apple.reminders");

        configAppiumDriver(cap);

        IOSDriver iosDriver = (IOSDriver) driver;
        IOSReminderPage iosReminderPage = new IOSReminderPage(iosDriver);

        iosReminderPage.addReminder("reminder");

        HashMap<String, String> dataReminder = new HashMap<>();
        dataReminder.put("reminder_title", "Send the weekly report");
        dataReminder.put("reminder_day", "no");
        dataReminder.put("reminder_priority", "high");
        dataReminder.put("reminder_notes", "Don't forgot to add Steve to the email chain");

        iosReminderPage.completeReminder(dataReminder);

        //I verify created reminder
        String reminderFound = iosReminderPage.searchReminder(dataReminder.get("reminder_title"));
        String reminderExpected = "Send the weekly report, High priority, Reminders, Don't forgot to add Steve to the email chain";

        Assert.assertEquals(reminderExpected, reminderFound);

    }


}
