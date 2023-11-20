Feature: Registration can be initiated

  Background:
    Given I open TescoOnline
    When I accept cookies

  Scenario: Initiate registration
    When I click on Registration button
    Then I am directed to Registration page
    And Email address field is visible
    And Password field is visible
