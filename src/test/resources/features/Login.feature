Feature: Test
  #
  Background:user should be on the login page
    Given user is on the login page

  Scenario: Test
    When user login
    Then user is on the dashboard


  Scenario: Test2
    When user login as "Employee122"
    Then user is on the dashboard
