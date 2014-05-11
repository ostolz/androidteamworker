Feature: HomeScreen feature

  Scenario: As a valid user I can log into my app
    When I see "HomeScreen"
    Then I press "eventButton" 
	Then I see "CreateEventScreen"