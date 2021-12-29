Feature: JRI-001
  Description: issue description

  Scenario: Log into saucedemo using valid credentials
    Given the saucedemo.com is opened
    When a valid user logs in
    Then the inventory page is shown