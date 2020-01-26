@smoke
Feature: Users should be able to login


  Background:
    Given the user is on the login page


  @driver
  Scenario: Login as a driver
    When the users enter the driver information
    Then the user should be able to login
  @store_manager   @db
  Scenario: Login as a salesmanager
    When the users enter the salesmanager information
    Then the user should be able to login

  @sales_manager    @db
  Scenario: Login as a storemanager
    When the user enter the store manager information
    Then the user should be able to login
