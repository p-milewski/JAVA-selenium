Feature: Hotel register

  Scenario: create an account
    Given an open browser with hotel website
    When email address is entered in input field
    And select first name
    And select last name
    And select password
    Then click register button
    And close browser


