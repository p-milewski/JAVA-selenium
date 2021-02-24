Feature: incorrect login to online platform
  Scenario: registered user cannot login to the platform with incorrect login and password
    Given open browser with platform website
    When click login on the website
    When enter incorrect email
    When enter incorrect password
    Then click sign in with incorrect login and password
    Then exit browser