Feature: SQM2122T06-25

  Background:
    Given the saucedemo.com is opened
    And a valid user logs in
    And a user adds an item to the cart
    And a user clicks the cart
    And a user clicks checkout
    And a user continues correctly

    Scenario: A user wants to cancel their order
      When a user cancels the order
      Then the inventory page is shown

      Scenario: A user wants to finish their order
        When a user finishes the order
        Then the checkout complete page is shown