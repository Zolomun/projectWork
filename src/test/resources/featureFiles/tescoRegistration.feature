Feature: Registration can be initiated

  Background:
    Given I open TescoOnline
    When I accept cookies

  Scenario Outline: Registration to site
    When I register with the following details "<email>" and "<password>" and "<firstName>" and "<lastName>" and "<primaryPhone>":
    Then I can see the Sign out button

    Examples:
      | email                              | password        | firstName | lastName | primaryPhone |
      | your.email+fakedata13604@gmail.com | iH424_tZzFIzdYx | valami    | valaki   | 36405888888  |

