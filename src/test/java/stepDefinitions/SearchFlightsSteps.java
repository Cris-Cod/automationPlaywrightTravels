package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.FlightsPage;
import pages.HomePage;
import pages.TickestPage;
import utils.BaseTest;

public class SearchFlightsSteps extends BaseTest {

    HomePage homePage;
    FlightsPage flightsPage;
    TickestPage tickestPage;

    @Given("the user is on the flight page")
    public void the_user_is_on_the_flight_page() {
        launchPage("chrome", "false", "https://www.expedia.com/");
        homePage = new HomePage(page);
        homePage.setSelectItem("Flights");
    }

    @Given("selects round-trip and type class {string}")
    public void selects_round_trip_and_type_class(String type) {

        type = "Business class";

        flightsPage = new FlightsPage(page);

        flightsPage.selectBtnRoundTrip();
        flightsPage.selectCategory(type);

    }

    @Given("enters the city from {string} and city to {string}")
    public void enters_the_city_from_and_city_to(String city_a, String city_b) {

        city_a = "Bogota";
        city_b = "London";

        flightsPage = new FlightsPage(page);

        flightsPage.selectLeavingFrom(city_a);
        flightsPage.selectGoingTo(city_b);
    }

    @Given("selects the departure dates {string} and {string}, and the return dates {string} and {string}")
    public void selects_the_departure_dates_and_and_the_return_dates_and(String monthFrom, String dateFrom, String monthTo, String dateTo) {
        monthFrom = "June 2025";
        dateFrom = "4";
        monthTo = "July 2025";
        dateTo = "20";

        flightsPage = new FlightsPage(page);

        flightsPage.selectDateFrom(monthFrom, dateFrom);
        flightsPage.selectDateTo(monthTo, dateTo);
    }

    @Given("enters the number {string} of adult travelers and number {string} of child travelers")
    public void enters_the_number_of_adult_travelers_and_number_of_child_travelers(String numAdults, String numChild) {
       flightsPage = new FlightsPage(page);

        numAdults = "2";
        numChild = "2";
        String ageChild_1 = "6";
        String ageChild_2 = "3";

        int numeroA = Integer.parseInt(numAdults);
        int numeroC = Integer.parseInt(numChild);

        flightsPage.selectTravelers(numeroA, numeroC, ageChild_1, ageChild_2);
    }

    @When("the user clicks the Search Flights button")
    public void the_user_clicks_the_search_flights_button() {
        flightsPage = new FlightsPage(page);

        flightsPage.selectBtnSearch();
    }

    @Then("all matching flights should be displayed")
    public void all_matching_flights_should_be_displayed() {
        tickestPage = new TickestPage(page);
        String title = tickestPage.validetaTextRecommended();
        Assert.assertEquals(title, "Recommended departing flights");
    }
}
