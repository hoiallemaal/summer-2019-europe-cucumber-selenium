Feature: Account types

  Scenario: Driver user
    Given the user logged in as a "driver"
    When the user navigates "Activities"  "Calender Events"
    Then the title should contains "Calender Events - Activities"


    Scenario: sales manager user
      Given the user logged in as a "sales manager"
      When the user navigates "Customers"  "Accounts"
      Then the title should contains "Accounts - Customers"


  Scenario: store manager user
    Given the user logged in as a "store manager"
    When the user navigates "Contacts"  "Call"
    Then the title should contains "All - Campaigns - Marketing"


      # we are trying to run al these scenarios in ddt   the following does what the previous 3 do.

    Scenario Outline: Login with different users <usertypes>
      Given the user logged in as a "<usertypes>"
      When the user navigates "<tab>"  "<module>"
      Then the title should contains "<title>"

      Examples:
      |usertypes    | tab      |  module       |title                       |
      |driver       |Activities|Calender Events|Calender Events - Activities|
      |sales manager|Customers |Accounts       |Accounts - Customers        |
      |store manager|Marketing |Campaigns      |All - Campaigns - Marketing |




  Scenario Outline: Login with different users <usertypes>
    Given the user logged in as a "<usertypes>"
    When the user navigates "<tab>" "<module>"
    Then the title should contains "<title>"

    Examples: drivers
      | usertypes     | tab        | module          | title                                                              |
      | driver        | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System       |
      | driver        | Customers  | Accounts        | Accounts - Customers                                               |
      | driver        | Customers  | Contacts        | Contacts - Customers                                               |
      | driver        | Activities | Calendar Events | Calendar Events - Activities                                       |
      | driver        | System     | Jobs            | Jobs - System                                                      |
      | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | sales manager | System     | Jobs            | All - Jobs - System                                                |
      | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | store manager | System     | Jobs            | All - Jobs - System                                                |
      | store manager | System     | Menus           | All - Menus - System                                               |
