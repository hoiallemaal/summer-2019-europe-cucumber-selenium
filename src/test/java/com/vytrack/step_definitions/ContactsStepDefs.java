package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.compress.compressors.brotli.BrotliUtils;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {

    @Then("the user should see following menu options")
    public void the_user_should_see_following_menu_options(List<String> menuOptions) {
        System.out.println("menuOptions.size =" +menuOptions.size());
        System.out.println("menuOptions.size ="+menuOptions );

        //get value from website
        BrowserUtils.waitFor(10);
       DashboardPage dashboardPage=new DashboardPage();
       List<String> actualMenuOptions=BrowserUtils.getElementsText(dashboardPage.menuOptions) ;

       //compare actual list from website and expected list from scenerio
        Assert.assertEquals(menuOptions,actualMenuOptions);
    }

    @When("the use logs in using following credentials")
    public void the_use_logs_in_using_following_credentials(Map<String, String> userData) {

        new LoginPage().login(userData.get("username"),userData.get("password"));
        //verify fullname on the top right corner from website with firstname,lastname from map
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        String actualFullname = dashboardPage.getUserName();
        String expectedFullname= userData.get("firstname")+" "+userData.get("lastname");
        Assert.assertEquals(expectedFullname,actualFullname);


            }
}
