Feature: Search Flights

  Scenario: Validate flights with two cities
    Given the user is on the flight page
    And selects round-trip and type class "Business class"
    And enters the city from "city from" and city to "city to"
    And selects the departure dates "month" and "date", and the return dates "month" and "date"
    And enters the number "number" of adult travelers and number "number" of child travelers
    When the user clicks the Search Flights button
    Then all matching flights should be displayed