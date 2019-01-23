Feature: Test Search page using search textbox also using filter and sort


  Background: User is Logged In
    Given User navigate to the login page
    When User submit username "shuvo" and password "123456"
    Then User will click Sign In button
    And User will see Account menu
    Then User will enter text "Honey"
  Scenario: Searching with name of honey
    Given User is Suceesfully loged in
    Given User will enter text "honey"
    And User will see press enter or click search button
    Then User will see the list of honey
  Scenario: Search with invalid data
    Given User will enter invalid text
    And  User will press enter or click serach icon
    Then User will see the message invalid search




