package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public  void setUp(){

        Driver.get().manage().window().maximize();
    }
    @After
    public void tearDown(Scenario scenario){

        //if the scenerio fails take the screen shot
        if(scenario.isFailed()){
            final byte [] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");

        }
        //Driver.closeDriver();
    }
    @After("@store_manager")
    public void tearDownStoreManager(){

        System.out.println("\tthis is coming from AFTER STORE MANAGER\n");
    }
    @After("@db")
    public void tearDownDatabase(){
        System.out.println("\tCLOSING DATABASE CONNECTION");
    }
    @Before("@db")
    public void setUpDatabase(){
        System.out.println("\tCONNECTION DATABASE");
    }
}
