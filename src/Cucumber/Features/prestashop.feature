Feature: User can add new address after login

  Scenario Outline: Creating new address

    Given an open browser with website of the platform

    When click sign in on the main site

    And enter email address

    And enter password

    And click sing in

    And click addresses

    And click create new address

    And enter "<alias>" "<address>" "<city>" "<postal>" "<phone>"

    And click save

    And click my account

    And enter my addresses

    Then click delete



    Examples:
      |       alias      |      address    |     city     | postal |      phone     |
      |    Darth Vader   |     Death Star  |    Paris     | 43-231 |    846-231-654 |
