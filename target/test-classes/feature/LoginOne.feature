Feature: Login functionality

  Scenario: Verify user able to login with valid credentials
    Given User navigate to login page
    When User enter valid email address "mohangunanithieee@gmail.com" into email address field
    And User enter valid password "Mohan@18989" into password field
    And User click on login button
    Then User logged in successfully

  Scenario: Verify user unable to login with invalid credentials
    Given User navigate to login page
    When User enter invalid email address "hdjdh@gmail.com" into email address field
    And User enter invalid password "Man@18989" into password field
    And User click on login button
    Then Error message should be displayed

  Scenario: Verify user unable to login with valid email address and invalid password
    Given User navigate to login page
    When User enter valid email address "mohangunanithieee@gmail.com" into email address field
    And User enter invalid password "Helo@1989" into password field
    And User click on login button
    Then Error message should be displayed

  Scenario: Verify user unable to login with invalid email address and valid password
    Given User navigate to login page
    When User enter invalid email address "123dh@gmail.com" into email address field
    And User enter valid password "Hello@1989" into password field
    And User click on login button
    Then Error message should be displayed

  Scenario: Verify user unable to login with blank email address and password
    Given User navigate to login page
    When User dont enter email address into email address field
    And User dont enter password into password field
    And User click on login button
    Then Error message should be displayed
