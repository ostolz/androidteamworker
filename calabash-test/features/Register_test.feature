Feature: Register feature

  Scenario: As a valid user I can log into my app
    When I see "TeamPlanBuch"
    Then I press "Register"
    Then I see "RegisterScreen"
	
	I fill in text fields as follows:
	| field      | text    |
	| reg_username  | username  |
	| vorname      | vorname  |
	| nachname   | nachname  |
	| strasse | strasse |
	| plz | plz|
	| wohnort | wohnort |
	| mail | mail |
	| reg_password   | 123     |
	| password_confirm    | 123     |
	
	Then I press "Submit"
	Then I see "LoginScreen"