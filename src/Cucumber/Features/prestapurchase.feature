Feature: User can complete order on prestashop

  Scenario: Step by step buying item

    Given user logging in to prestashop

    And search Hummingbird Printed Sweater in field

    And select Hummingbird Printed Sweater product

    And select M size

    And increase quantity to 5

    And proceed to checkout

    And click continue on the address field

    And shipping method - click continue

    And select pay by check

    And click on terms of service

    And click order with obligatory payment

    And make a printscreen

    And click user

    And click order history and details