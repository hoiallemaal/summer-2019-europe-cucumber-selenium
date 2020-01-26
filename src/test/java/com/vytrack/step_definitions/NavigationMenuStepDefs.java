package com.vytrack.step_definitions;

import com.vytrack.pages.AllCalenderEventsPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.CreateCalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.compress.compressors.brotli.BrotliUtils;
import org.junit.Assert;


import javax.swing.*;

public class NavigationMenuStepDefs {

    @Given("the users enter the sales manager information")
    public void the_users_enter_the_sales_manager_information() {
        System.out.println("");
    }

    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {

    }

    @Then("the url should be expected Fleet url")
    public void the_url_should_be_expected_Fleet_url() {
        System.out.println("Navigate to Fleet Vehicles");

    }

    @When("the users navigates Marketing Campaigns")
    public void the_users_navigates_Marketing_Campaigns() {
        System.out.println("Navigate to Marketing Campaigns");
    }

    @Then("the url should be expected Campaigns url")
    public void the_url_should_be_expected_Campaigns_url() {
        System.out.println("Navigate to Activities Calender events");
    }



    @Then("the url should be expected Activities url")
    public void the_url_should_be_expected_Activities_url() {

        DashboardPage dashboardPage=new DashboardPage();
        //dashboardPage.navigateToModule(String Activities, String Ca);

    }

    @When("the user navigates {string}  {string}")
    public void the_user_navigates(String tab, String module) {
        new DashboardPage().navigateToModule(tab,module);
    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer ePagenumber) {

        ContactsPage contactsPage=new ContactsPage();
        Integer actualNumber=Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(actualNumber,ePagenumber);
    }

    @Then("the user hover on three dots {string} for {string}")
    public void the_user_hover_on_three_dots_for(String string, String string2) {

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.gotocalender();
        BrowserUtils.waitFor(5);

        AllCalenderEventsPage allCalenderEventsPage=new AllCalenderEventsPage();
        BrowserUtils.hover( allCalenderEventsPage.massActions);


    }
    @When("click on create calender event button")
    public void click_on_create_calender_event_button() {

        AllCalenderEventsPage allCalenderEventsPage=new AllCalenderEventsPage();
        allCalenderEventsPage.createcalenderbutton.click();

    }

    @Then("expand save and close menu")
    public void expand_save_and_close_menu() {
    AllCalenderEventsPage allCalenderEventsPage=new AllCalenderEventsPage();
    allCalenderEventsPage.calendereventbutton();
    }

    @Then("verify that Save and close options are avaliable")
    public void verify_that_Save_and_close_options_are_avaliable() {
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.SaveAndClose();

        CreateCalendarEventsPage createCalendarEventsPage1=new CreateCalendarEventsPage();
        createCalendarEventsPage1.subsaveandclose();

    }
}
