Feature: HomeScreen feature

  Scenario: As a valid user I can log into my app
    When I see "TeamPlanBuch"
	Then I press "Login"
    Then I see "HomeScreen"
	Then I press "Termin erstellen" 
	Then I see "CreateEventScreen"