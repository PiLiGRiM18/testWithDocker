@demoTest
Feature: Demo feature 1

  Scenario: Open Wikipedia and search something 1
    Given I am on the "Wikipedia" page
    And I type "Жопа 1" in inputfield with id "searchInput"
    And I press "Search" button
    Then the page is reloaded
    And search result is shown
    And the feature is completed

  Scenario: Open Google and search something 1
    Given I am on the "Google" page
    And I type "Жопа 1" in inputfield with id "searchInput"
    And I press "Search" button
    Then the page is reloaded
    And search result is shown
    And the feature is completed