Feature: Login The Ninja Store
  @Login
  Scenario: Login The Ninja Store page with an existing account
    Given the user goes to login page
    When the user login entering his email and password
    Then "My Account" tittle is shown

  @Login
  Scenario: Login The Ninja Store page with an existing account
    Given the user goes to login page
    When the user login entering his email and password
    Then "My Account" tittle is shown
