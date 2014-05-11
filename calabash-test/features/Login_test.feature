Feature: Login feature

  Scenario: As a valid user I can log into my app
    When I see "TeamPlanBuch"
    Then I enter "username" into the "log_username" input field
	Then I enter "password" into the "log_password" input field
	
	Then I press "Login"
	Then I see "HomeScreen"