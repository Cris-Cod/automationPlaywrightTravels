package pages;

import com.microsoft.playwright.Page;

public class TickestPage {

    private Page page;

    public TickestPage(Page page) {
        this.page = page;
    }

    private String textRecommendedFlights = "//h5[@data-test-id='listings-header-recommended']";

    public String validetaTextRecommended() {
        String title = page.locator(textRecommendedFlights).textContent();
        return title;
    }
}
