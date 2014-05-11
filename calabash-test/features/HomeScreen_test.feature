Feature: HomeScreen feature

  Scenario: As a valid user I can log into my app
    When I press "Login"
    Then I see "HomeScreen"
    Then I press "eventButton" 
    Then I see "CreateEventScreen"