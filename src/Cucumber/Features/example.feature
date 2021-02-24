Feature: User can add new address after login


  Scenario Outline: Creating new address


    Then click save

    Examples:
      |       alias      |      address    |     city     | postal |      phone      |
      |    Darth Vader   |    Death Star   |    Paris     | 43-231 |    846-231-654  |
