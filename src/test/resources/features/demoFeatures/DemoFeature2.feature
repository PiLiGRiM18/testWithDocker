@demoTest
Feature: Demo feature 2

  Scenario: Open Wikipedia and search something 2
    Given I am on the "https://www.wikipedia.org/" page
    And I type "Search something 2" in inputfield with id "searchInput"
    And I press "Search" button
    Then the page is reloaded
    And search result is shown
    And the feature is completed