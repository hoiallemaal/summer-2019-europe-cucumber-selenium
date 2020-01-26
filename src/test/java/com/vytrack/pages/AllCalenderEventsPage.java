package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AllCalenderEventsPage extends BasePage {

    public AllCalenderEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    // String xpath = "//table[@id='table1']/tbody/tr["+ r +"]/td["+ c +"]";

    int r = 5;
    int c = 9;

    @FindBy(xpath = "//table/tbody/tr[5]/td[9]")
    public WebElement massActions;

    @FindBy(xpath = "//a[@title='Grid Settings']/i")
    public WebElement gridSettings;

    @FindBy(xpath ="//div/a[contains(text(),'Create')]")
    public WebElement createcalenderbutton;


    @FindBy(xpath ="(//h1)[2]")
    public WebElement allCalender;

    public void calendereventbutton() {
        createcalenderbutton.click();
    }


    public void allcalendertext() {

      //Assert.assertTrue(allCalender.isDisplayed(),"verify that all Calender Events text is displyed");
    }












    }

    // public WebElement hoverovermark(){


// String markXpath = "//table/tbody/tr["+r+"]/td["+c+"]";
//   BrowserUtils hh=new BrowserUtils();

//
//  return Driver.get().findElement(By.xpath(markXpath));