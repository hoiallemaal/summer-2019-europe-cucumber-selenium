@navigate
Feature: Navigation menu

  Scenario: Fleet --> Vehicles
    Given the user is on the login page
    And the users enter the sales manager information
    When the user navigates to Fleet, Vehicles
    Then the url should be expected Fleet url
@smoke
  Scenario: Sales manager-Marketing-->Campaigns
    Given the user is on the login page
    And the users enter the sales manager information
    When the users navigates Marketing Campaigns
    Then the url should be expected Campaigns url

@smoke
  Scenario: Activities--> Calender Events
    Given the user is on the login page
    And the users enter the salesmanager information
    When the user navigates Activities-Calender events
    Then the url should be expected Activities url


  Scenario: Activities--> Calender Events
    Given the user is on the login page
    And the user enter the store manager information
    When the user navigates Activities-Calender events
    Then the user hover on three dots "..." for "Testers  meeting"


  Scenario: Activities--> Save and Close
    Given the user is on the login page
    And the user enter the store manager information
    When the user navigates "Activities"  "Calender Events"
    And click on create calender event button
    Then expand save and close menu
    And verify that Save and close options are avaliable