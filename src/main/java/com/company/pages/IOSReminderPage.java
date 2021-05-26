package com.company.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class IOSReminderPage {

    private IOSDriver driver;

    // DEFINING LOCATORS #
    private By btnAdd = By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]");

    //Add reminder option
    private By btnAddReminder = By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeSheet[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]");

    //# Reminder Title
    private By txtReminderTitle = By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeTextView[1]");

    //# Add list option for find by AccessibilityId
    private String btnAddList = "List";

    //# Back for find by AccessibilityId
    private String btnBack = "Stack of other lists";

    //# Remind me day for find by AccessibilityId
    private String btnReminderDay = "Remind me on a day";

    //# Priority none for find by AccessibilityId
    private String btnPriorityNone = "None";

    //# Priority Low for find by AccessibilityId
    private String btnPriorityLow = "Low";

    //# Priority Medium for find by AccessibilityId
    private String btnPriorityMedium = "Medium";

    //# Priority High for find by AccessibilityId
    private String btnPriorityHigh = "High";

    //# Reminder Notes
    private By txtReminderNotes = By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[last()]/XCUIElementTypeTextView");

    //# Done for find by AccessibilityId
    private String btnDone = "Done";

    //# Search for find by AccessibilityId
    private String txtSearchReminder = "Search";

    //# First search result
    private By firstSearchResult = By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]");


    public IOSReminderPage(IOSDriver driver) {
        this.driver = driver;
    }


    public void addReminder(String reminderType) {
        try {
            driver.findElementByAccessibilityId(btnBack).click();
        } catch (Exception e) {

        }

        driver.findElement(btnAdd).click();

        if (reminderType.equalsIgnoreCase("reminder"))
            driver.findElement(btnAddReminder).click();
        else if (reminderType.equalsIgnoreCase("list"))
            driver.findElementByAccessibilityId(btnAddList).click();

    }

    public void completeReminder(Map<String, String> criteria) {
        driver.findElement(txtReminderTitle).sendKeys(criteria.get("reminder_title"));

        if (criteria.get("reminder_day").toLowerCase().equals("yes"))
            completeReminderDay(criteria);

        setPriority(criteria.get("reminder_priority"));

        if (criteria.get("reminder_notes") != null) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtReminderNotes)));

            driver.findElement(txtReminderNotes).click();
            driver.findElement(txtReminderNotes).sendKeys(criteria.get("reminder_notes"));
        }

        driver.findElementByAccessibilityId(btnDone).click();
    }

    public void completeReminderDay(Map<String, String> criteria) {
        driver.findElementByAccessibilityId(btnReminderDay).click();
        //# TODO: Complete reminder day, hour, min and am/pm
        /*if criteria[:reminder_day]
        true
        end
        if criteria[:reminder_hour]
        true
        end
        if criteria[:reminder_min]
        true
        end
        if criteria[:reminder_am_pm]
        true
        end*/
    }

    public void setPriority(String priority) {
        if (priority.toLowerCase().equalsIgnoreCase("none")) {
            driver.findElementByAccessibilityId(btnPriorityNone).click();
        } else if (priority.toLowerCase().equalsIgnoreCase("low")) {
            driver.findElementByAccessibilityId(btnPriorityLow).click();
        } else if (priority.toLowerCase().equalsIgnoreCase("medium")) {
            driver.findElementByAccessibilityId(btnPriorityMedium).click();
        } else if (priority.toLowerCase().equalsIgnoreCase("high")) {
            driver.findElementByAccessibilityId(btnPriorityHigh).click();
        }
    }

    public String searchReminder(String reminder) {
        driver.findElementByAccessibilityId(txtSearchReminder).sendKeys(reminder);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstSearchResult)));


        return driver.findElement(firstSearchResult).getText();
    }
}
