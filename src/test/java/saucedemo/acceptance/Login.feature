Feature: SQM2122T06-11, SQM2122T06-33
  Description: As a user I want to login with valid credentials

  Scenario: Log into saucedemo using valid credentials
    Given the saucedemo.com is opened
    When a valid user logs in
    Then the inventory page is shown

  Scenario: Log into saucedemo without using a password
    Given the saucedemo.com is opened
    When a user tries to login without a password
    Then the login page is shown with an error

  Scenario: Log into saucedemo without using a username
    Given the saucedemo.com is opened
    When a user tries to login without a username
    Then the login page is shown with an error

  Scenario: Log into saucedemo with a wrong password
    Given the saucedemo.com is opened
    When a user tries to login with a wrong password
    Then the login page is shown with an error

  Scenario: Log into saucedemo as a locked out user
    Given the saucedemo.com is opened
    When a locked out user tries to login
    Then the login page is shown with an error

  Scenario: Log into saucedemo with a wrong username
    Given the saucedemo.com is opened
    When a user tries to login with a wrong username
    Then the login page is shown with an error


