package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CreateCalendarEventsPage extends BasePage {

    public CreateCalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(xpath = "//input[contains(@id,'time_selector_oro_calendar_event_form_start')]")
    public WebElement startTime;
    //[id^='time_selector_oro_calendar_event_form_start']

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;

    @FindBy(xpath = "//*[@class='datepicker-input hasDatepicker']")
    public WebElement byDate;


    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    public WebElement saveclose;

    @FindBy(xpath = "//*[@class='action-button dropdown-item']")
    public WebElement subsaveclose;

    @FindBy(xpath = "//*[@class='main-group action-button dropdown-item']")
    public WebElement subsaveandnew;


    @FindBy(xpath = "(//*[@class='main-group action-button dropdown-item'])[2]")
    public WebElement subsave;

    @FindBy(xpath = "//*[@class='btn back icons-holder-text ']")
    public WebElement cancelevent;


    @FindBy(xpath = "(//div/span)[15]")
    public WebElement summarymessageday;

    @FindBy(xpath = "(//div/span)[16]")
    public WebElement summarymessageend;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement a_d_event;

    @FindBy(xpath = "(//select)[1]")
    public  WebElement repeatselect;

    @FindBy(xpath = "//*[contains(text(),'Daily every')]")
    public  WebElement summary;

    @FindBy(xpath = "//*[contains(text(),', end after 10 occurrences')]")
    public  WebElement summary1;

    @FindBy(xpath = "(//*[@class='recurrence-subview-control__number'])[7]")
    public  WebElement repeatocurrunces;


    @FindBy(xpath = "((//span[@class='recurrence-subview-control__text'])[1]")
    public  WebElement asAspace;






     public Select repeatOptionsList() {

     return new Select(repeatOptions);
    }

    public void SaveAndClose() {

        saveclose.click();
    }

    public void subsaveandclose() {

        String actualsubsaveclose = subsaveclose.getText();
        String actualsaveandnew = subsaveandnew.getText();
        String actualsubsave = subsave.getText();

        String expectedsaveandclose = "Save And Close";
        String expectedsaveandnew = "Save And New";
        String expectedsave = "Save";
        Assert.assertEquals(actualsubsaveclose, expectedsaveandclose, "verify that subsaveandclose is equal to expected");
        Assert.assertEquals(actualsaveandnew, expectedsaveandnew, "verify that subsaveandnew is equal to expected");
        Assert.assertEquals(actualsubsave, expectedsave, "verify that subsave is equal to expected");

    }

    public void Cancel() {
        cancelevent.click();


    }

    public void differenceStartandEnd() {
        // this method finds the time of start and end and than convert string to int by using array with split method..

       // System.out.println(startTime.getAttribute("value"));
      //  System.out.println(endTime.getAttribute("value"));

        String arr [] = startTime.getAttribute("value").split(":");
        String arr1 [] = endTime.getAttribute("value").split(":");
            String b=arr[0];
            String c=arr1[0];
        int number=Integer.parseInt(b);
        int number1=Integer.parseInt(c);
        String actualdiffer="0";

        if(number1-number==1){
           actualdiffer="1";
        }
        Assert.assertEquals(actualdiffer,"1");
    }




    public void displaysummary() {

        String actualsummary1=summarymessageday.getText();
        String actualsummary2=summarymessageend.getText();


        Assert.assertEquals(actualsummary1,"Daily every 1 day");
        Assert.assertEquals(actualsummary2,", end by Nov 18, 2021");

    }
}