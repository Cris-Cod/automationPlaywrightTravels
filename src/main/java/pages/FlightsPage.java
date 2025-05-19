package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class FlightsPage {

    private Page page;

    public FlightsPage(Page page) {
        this.page = page;
    }

    private String btnRoundTrip = "//a[@aria-controls='FlightSearchForm_ROUND_TRIP']";
    private String btnOneWay = "//a[@aria-controls='FlightSearchForm_ONE_WAY']";
    private String btnMulticity = "//a[@aria-controls='FlightSearchForm_MULTI_DESTINATION']";
    private String btnClass = "#cabin_class";
    private String list_category = "//ul[@role='list']/li";
    private String btnLeavingFrom = "//button[@aria-label='Leaving from']";
    private String inputLeavingFrom = "#origin_select";
    private String btnGoingTo = "//button[@aria-label='Going to']";
    private String inputgoingTo = "#destination_select";
    private String btnDates = "//button[@data-testid='uitk-date-selector-input1-default']";
    private String dateMonth = "(//span[@class='uitk-align-center uitk-month-label'])[1]";
    private String list_days = "//tbody[@class='uitk-day-wrap']/tr/td";
    private String btn_next_calendar = "//button[@data-stid='uitk-calendar-navigation-controls-next-button']";
    private String btn_previous_calendar = "//button[@data-stid='uitk-calendar-navigation-controls-previous-button']";
    private String btnDone = "//button[@data-stid='apply-date-selector']";
    private String btnTraveler = "//button[@data-stid='open-room-picker']";
    private String btnAdultsMinus = "(//div[@class='uitk-layout-flex uitk-layout-flex-item uitk-step-input-controls'])[1]/button[1]";
    private String btnAdultsMax = "(//div[@class='uitk-layout-flex uitk-layout-flex-item uitk-step-input-controls'])[1]/button[2]";
    private String btnChildrenMinus = "(//div[@class='uitk-layout-flex uitk-layout-flex-item uitk-step-input-controls'])[2]/button[1]";
    private String btnChildrenNax = "(//div[@class='uitk-layout-flex uitk-layout-flex-item uitk-step-input-controls'])[2]/button[2]";
    private String btnDoneTraveler = "#travelers_selector_done_button";
    private String btnSearch = "#search_button";

    public void selectBtnRoundTrip(){
        page.locator(btnRoundTrip).click();
    }

    public void selectBtnOneWay(){
        page.locator(btnOneWay).click();
    }

    public void selectBtnMulticity(){
        page.locator(btnMulticity).click();
    }

    public void selectBtnCategory(){
        page.locator(btnClass).click();
    }

    public void selectCategory(String category){
        Locator allCategory = page.locator(list_category);
        List<String> allNames = allCategory.allInnerTexts();

        for (int i = 0; i < allNames.size(); i++) {
            if(allNames.get(i).equalsIgnoreCase(category)){
                allCategory.nth(i).click();
                break;
            }
        }
    }

    public void selectLeavingFrom(String city){
        page.locator(btnLeavingFrom).click();
        page.locator(inputLeavingFrom).fill(city);
        page.keyboard().press("Enter");
    }

    public void selectGoingTo(String city){
        page.locator(btnGoingTo).click();
        page.locator(inputgoingTo).fill(city);
        page.keyboard().press("Enter");
    }

    public void selectDateFrom(String monthFrom, String dateFrom) {
        page.locator(btnDates).click();
        String month = page.locator(dateMonth).textContent();
        Locator allDays = page.locator(list_days);
        List<String> nameDays = allDays.allInnerTexts();

        while (!month.equalsIgnoreCase(monthFrom)) {
            page.locator(btn_next_calendar).click();
            month = page.locator(dateMonth).textContent();
        }

        for (int i = 0; i < nameDays.size(); i++) {
            if (nameDays.get(i).equalsIgnoreCase(dateFrom)) {
                allDays.nth(i).click();
                break;
            }
        }

    }

    public void selectDateTo(String monthTo, String dateTo){
        page.locator(btnDates).click();
        String month = page.locator(dateMonth).textContent();
        Locator allDays = page.locator(list_days);
        List<String> nameDays = allDays.allInnerTexts();

        while (!month.equalsIgnoreCase(monthTo)) {
            page.locator(btn_next_calendar).click();
            month = page.locator(dateMonth).textContent();
        }

        for (int i = 0; i < nameDays.size(); i++) {
            if (nameDays.get(i).equalsIgnoreCase(dateTo)) {
                allDays.nth(i).click();
                break;
            }
        }

        page.locator(btnDone).click();
    }

    public void selectTravelers(int amountAdults, int amountChildren){
        page.locator(btnTraveler).click();

        int numAdults = 1;
        int numChildren = 0;

        while (numAdults != amountAdults){
            page.locator(btnAdultsMax).click();
        }

        while (numChildren != amountChildren){
            page.locator(btnChildrenNax).click();
        }

        page.locator(btnDoneTraveler).click();

    }

    public void selectBtnSearch(){
        page.locator(btnSearch).click();
    }



}
