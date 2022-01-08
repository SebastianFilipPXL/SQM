Feature: SQM2122T06-24
  Description: As a user I want to fill in my credentials so my items get delivered to the right address

  Background:
    Given the saucedemo.com is opened
    And a valid user logs in
    And a user adds an item to the cart
    And a user clicks the cart
    And a user clicks checkout

    Scenario: A user fills in the form correctly
      When a user continues correctly
      Then the Product Overview Page is shown

    Scenario: A user forgets to fill in their first name
      When a user continues without a first name
      Then an error should be shown

    Scenario: A user forgets to fill in their last name
      When a user continues without a last name
      Then an error should be shown

    Scenario: A user forgets to fill in their postal code
      When a user continues without a postal code
      Then an error should be shown

    Scenario: A user forgets to fill in their information
      When a user continues without any information
      Then an error should be shown

      Scenario: A user wants to cancel their order
        When a user clicks cancel
        Then the cart page is shown


