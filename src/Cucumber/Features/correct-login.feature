Feature: correct login to online platform
  Scenario: registered user can login to the platform
    Given an open browser with platform website
    When click login
    When enter correct email
    When enter correct password
    Then click sign in
    Then exit browser