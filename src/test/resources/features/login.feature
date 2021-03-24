@featureTag  @login # feature level tag
Feature: Login Functionality

    @validCreds @smoke # scenario level tag
  Scenario: Login with valid credentials
    #Given navigate to HRMS login page
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    #And quit the browser

    @smoke @syntax @regression @whatever # adding multiple scenario level tags
  Scenario: Login with invalid credentials
    #Given navigate to HRMS login page
    When enter invalid credentials
    And click on login button
    Then verify error message
    #And quit the browser