Feature: Test Search page using search textbox also using filter and sort
  Scenario: Search with name of honey
    Given: User will enter text "honey"
    And: User will see press enter or click search button
    Then: User will see the list of honey
  Scenario: Search with invalid data
    Given: User will enter invalid text
    And : User will press enter or click serach icon
    Then : User will see the message invalid search




