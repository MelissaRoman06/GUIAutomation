Feature: Login The Ninja Store
  Scenario: Login The Ninja Store to an existing account
    Given the user enters his email and password
    When the user presses login button
    Then "My Account" text is displayed