Feature: Address book management

  @CheckLogin
  Scenario: User create a curriculum with the minimum data required
    When the user goes to add address page
    And the user adds a new address with minimum data required
      | First Name   | TestName       |
      | Last Name    | TestLastName   |
      | Address 1    | TestStreet 123 |
      | City         | TestCity       |
      | Post Code    | 12345          |
      | Country      | Bolivia        |
      | Region/State | Cochabamba     |
    Then a alert Your address has been successfully added is displayed
    And the address appears on Address Book Entries table
