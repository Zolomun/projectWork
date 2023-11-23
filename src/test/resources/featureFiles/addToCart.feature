Feature: Product can be added to the Cart

  Background:
    Given I open TescoOnline
    When I accept cookies
    When I log in with the following details "your.email+fakedata13598@gmail.com" and "iH424_tZzFIzdYx" and "valami":
    Then I can see welcome message with "valami"


  Scenario: adding a product to the Cart
    When I search and add a product to my cart: "tejföl"
    Then "tejföl" is visible in my cart

