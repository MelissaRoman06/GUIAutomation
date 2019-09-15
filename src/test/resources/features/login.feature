Feature: Login The Ninja Store

  @Login @CheckLogout
  Scenario: Login The Ninja Store page with an existing account
    Given the user goes to login page
    When the user login entering his email and password
    Then My Account title is shown
    And logout option is on dropdown menu
    And the used email appears on edit page

  @Login
  Scenario: Login The Ninja Store page with an existing account
    Given the user goes to login page
    When the user login entering his email and password
    Then My Account title is shown
    And logout option is on dropdown menu
    And the used email appears on edit page
