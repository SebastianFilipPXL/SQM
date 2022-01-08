Feature: SQM2122T06-13
  Description: As a user I want to view details of items

  Background:
    Given the saucedemo.com is opened
    And a valid user logs in
    And a user clicks the details page


  Scenario: A user opens the page
    Then the right details page is shown

  Scenario: A user wants to add the item to their cart
    When a user adds an item to the cart on details
    Then the item is added to the cart on details

  Scenario: A user wants to remove the item to their cart
    Given a user adds an item to the cart on details
    When  a user removes an item from the cart on details
    Then the item is removed from the cart on details

  Scenario: A user wants to go back to products
    When a user clicks on the back to products button
    Then the inventory page is shown