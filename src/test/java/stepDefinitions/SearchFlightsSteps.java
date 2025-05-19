package stepDefinitions;

import io.cucumber.java.en.*;
import pages.FlightsPage;
import pages.HomePage;
import utils.BaseTest;

public class SearchFlightsSteps extends BaseTest {

    HomePage homePage;
    FlightsPage flightsPage;

    @Given("the user is on the flight page")
    public void the_user_is_on_the_flight_page() {
        homePage = new HomePage(page);
        launchPage("chrome", "false", "https://www.expedia.com/");
        homePage.setSelectItem("Flights");
    }

    @Given("selects round-trip and type class {string}")
    public void selects_round_trip_and_type_class(String type) {
        flightsPage = new FlightsPage(page);

        flightsPage.selectBtnRoundTrip();
        flightsPage.selectCategory(type);

    }

    @Given("enters the city from {string} and city to {string}")
    public void enters_the_city_from_and_city_to(String city_a, String city_b) {
        flightsPage = new FlightsPage(page);

        flightsPage.selectLeavingFrom(city_a);
        flightsPage.selectGoingTo(city_b);
    }

    @Given("selects the departure dates {string} and {string}, and the return dates {string} and {string}")
    public void selects_the_departure_dates_and_and_the_return_dates_and(String monthFrom, String dateFrom, String monthTo, String dateTo) {
        flightsPage = new FlightsPage(page);

        flightsPage.selectDateFrom(monthFrom, dateFrom);
        flightsPage.selectDateTo(monthTo, dateTo);
    }

    @Given("enters the number {string} of adult travelers and number {string} of child travelers")
    public void enters_the_number_of_adult_travelers_and_number_of_child_travelers(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks the Search Flights button")
    public void the_user_clicks_the_search_flights_button() {
        flightsPage = new FlightsPage(page);

        flightsPage.selectBtnSearch();
    }

    @Then("all matching flights should be displayed")
    public void all_matching_flights_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
