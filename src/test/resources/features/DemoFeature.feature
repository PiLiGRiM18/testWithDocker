@smoketest
Feature: Demo local feature

  Scenario: Open Wikipedia and search something
    Given I am on the Wikipedia page
    And I type "qweqwe" in inputfield with id "searchInput"
    And I press 'Search" button
    Then The page is reloaded
    And Search result is shown