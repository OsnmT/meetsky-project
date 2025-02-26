Feature: Test
  #
  Background:user should be on the login page
    Given user is on the login page
    Given the user is on the login page


  Scenario: Test
    When user login
    Then user is on the dashboard


  Scenario: Test2
    When user login as "Employee122"
    Then user is on the dashboard

  @test
  Scenario: Verify login with different credentials
    Given the user logged in with username as "Employee121" and password as "Employee123"