#Author: jack@freddiemac.com
@searchEmployee
Feature: Seach an Employee

  Background: 
    Given enter valid credentials
    And click on login button
    And click on PIM
    And click on employee list button

  @regression
  Scenario: search employee job tittles
	When search for all job titles
	Then all job title from database are displayed