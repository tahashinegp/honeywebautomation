Feature: Test Search page using search textbox also using filter and sort
  Background: User is Logged In
    Given User navigate to the login page
    When User submit username "tahashin.egp@outlook.com" and password "123456"
    Then User will click Sign In button
    And User will see Account menu
  @scenario1
  Scenario: Search with name of honey
    Given: User will enter "honey"
    And: User will see press enter or click search button
    Then: User will see the list of honey



