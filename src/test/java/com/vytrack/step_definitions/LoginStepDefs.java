package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.security.auth.login.Configuration;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("opening the login page");
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the users enter the driver information")
    public void the_users_enter_the_driver_information() {
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        BrowserUtils.waitFor(5);
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals("Dashboard", actualTitle);

    }

    @When("the users enter the salesmanager information")
    public void the_users_enter_the_salesmanager_information() {
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("salesmanager_username");
        String password=ConfigurationReader.get("salesmanager_password");
        loginPage.login(username,password);
    }

    @When("the user enter the store manager information")
    public void the_user_enter_the_store_manager_information() {
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("storemanager_username");
        String password=ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
    }

    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }
    @Then("the title should contains {string}")
    public void the_title_should_contains(String expectedTitle) {
        BrowserUtils.waitFor(4);
        Assert.assertTrue("Actual title:"+Driver.get().getTitle(),Driver.get().getTitle().contains(expectedTitle));
    }
    @Given("the user logged in as a {string}")
    public void the_user_logged_in_as_a(String user) {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        String username = null;
        String password = null;

        if(user.equals("driver")){
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        }else if(user.equals("sales manager")){
            username = ConfigurationReader.get("salesmanager_username");
            password = ConfigurationReader.get("salesmanager_password");
        }else if(user.equals("store manager")){
            username = ConfigurationReader.get("storemanager_username");
            password = ConfigurationReader.get("storemanager_password");
        }
        BrowserUtils.waitFor(5);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @Given("User access to the toolsqa webpage")
    public void user_access_to_the_toolsqa_webpage() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("user can click on the new message window")
    public void user_can_click_on_the_new_message_window() {
        LoginPage loginPage=new LoginPage();
        loginPage.newx.click();
    }

    @Then("user gets the text from the new window")
    public void user_gets_the_text_from_the_new_window() {
        LoginPage loginPage=new LoginPage();

        String newwindow=Driver.get().getWindowHandle();
        BrowserUtils.switchToWindow(newwindow);

        System.out.println(loginPage.newx.getText());

    }

}