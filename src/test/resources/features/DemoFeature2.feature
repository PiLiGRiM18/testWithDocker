@demoTest
Feature: Demo local feature

  Scenario: Open Wikipedia and search something - 2
    Given I am on the "Wikipedia" page
    And I type "Жопа" in inputfield with id "searchInput"
    And I press "Search" button
    Then the page is reloaded
    And search result is shown
    And the feature is completed