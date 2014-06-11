Feature: Login feature

  Scenario: As a valid user I can log into my app
    When I see "TeamPlanBuch"
    Then I enter text "username" into field with id "log_username"
    Then I enter text "password" into field with id "log_password"
    Then I press "Login"
    Then I see "HomeScreen"