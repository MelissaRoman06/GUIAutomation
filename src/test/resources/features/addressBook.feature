Feature: Address book management

  @CheckLogin @DeleteAddress
  Scenario: Add new address to address book
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
