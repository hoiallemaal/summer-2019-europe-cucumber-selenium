package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {


    //find locaters of activity
    @FindBy(xpath = "(//li/a/span)[17]")
    public WebElement activityInDashboard;

    //find the locaters of calender
    @FindBy(xpath = " (//li/a/span)[19]")
    public WebElement CalenderInDashboard;
    public void gotocalender(){
        activityInDashboard.click();
        CalenderInDashboard.click();



    }
}
