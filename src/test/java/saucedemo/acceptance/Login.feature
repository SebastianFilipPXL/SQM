Feature: JRI-001
  Description: issue description

  Scenario: Log into the heroku app using valid credentials
    Given the heroku app is opened
    When a valid user logs into the app
    Then a welcome message is shown