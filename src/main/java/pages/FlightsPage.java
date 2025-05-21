package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Collections;
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
    private String dateMonth = "//span[@class='uitk-align-center uitk-month-label']";
    private String list_days_left = "//div[@class='uitk-month uitk-month-double uitk-month-double-left']/table/tbody/tr/td";
    private String list_days_right = "//div[@class='uitk-month uitk-month-double uitk-month-double-right']/table/tbody/tr/td";
    private String btn_next_calendar = "//button[@data-stid='uitk-calendar-navigation-controls-next-button']";
    private String btn_previous_calendar = "//button[@data-stid='uitk-calendar-navigation-controls-previous-button']";
    private String btnDone = "//button[@data-stid='apply-date-selector']";
    private String btnTraveler = "//button[@data-stid='open-room-picker']";
    private String btnAdultsMinus = "(//div[@class='uitk-layout-flex uitk-layout-flex-item uitk-step-input-controls'])[1]/button[1]";
    private String btnAdultsMax = "(//div[@class='uitk-layout-flex uitk-layout-flex-item uitk-step-input-controls'])[1]/button[2]";
    private String btnChildrenMinus = "(//div[@class='uitk-layout-flex uitk-layout-flex-item uitk-step-input-controls'])[2]/button[1]";
    private String btnChildrenNax = "(//div[@class='uitk-layout-flex uitk-layout-flex-item uitk-step-input-controls'])[2]/button[2]";
    private String ageChild_1 = "#age-traveler_selector_children_age_selector-0";
    private String ageChild_2 = "#age-traveler_selector_children_age_selector-1";
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
        Locator allMonths = page.locator(dateMonth);
        List<String> nameMonths = allMonths.allInnerTexts();
        Locator allDays = page.locator(list_days_left);
        List<String> nameDays = allDays.allInnerTexts();
        boolean monthfound = false;

        while (!monthfound){
            for (String months: nameMonths){
                if(months.equalsIgnoreCase(monthFrom)){
                    monthfound = true;
                    break;
                }
            }

            if(!monthfound){
                page.locator(btn_next_calendar).click();
                page.waitForTimeout(300);
            }
        }

        for (int j = 0; j < nameDays.size(); j++) {
            if (nameDays.get(j).equalsIgnoreCase(dateFrom)) {
                allDays.nth(j).click();
                break;
            }
        }

    }

    public void selectDateTo(String monthTo, String dateTo){
        Locator allMonths = page.locator(dateMonth);
        List<String> nameMonths = allMonths.allInnerTexts();
        Locator allDays = page.locator(list_days_right);
        List<String> nameDays = allDays.allInnerTexts();

        boolean monthfound = false;

        while (!monthfound){
            for (String months: nameMonths){
                if(months.equalsIgnoreCase(monthTo)){
                    monthfound = true;
                    break;
                }
            }

            if(!monthfound){
                page.locator(btn_next_calendar).click();
                page.waitForTimeout(300);
            }
        }

        for (int j = 0; j < nameDays.size(); j++) {
            if (nameDays.get(j).equalsIgnoreCase(dateTo)) {
                allDays.nth(j).click();
                break;
            }
        }

        page.locator(btnDone).click();
    }

    public void selectTravelers(int amountAdults, int amountChildren, String age1, String age2){
        page.locator(btnTraveler).click();

        int numAdults = 1;
        int numChildren = 0;

        while (numAdults < amountAdults){
            page.locator(btnAdultsMax).click();
            numAdults++;

        }

        while (numChildren < amountChildren){
            page.locator(btnChildrenNax).click();
            numChildren++;
        }

        Locator ageChild1 = page.locator(ageChild_1);
        ageChild1.selectOption(age1);

        Locator ageChild2 = page.locator(ageChild_2);
        ageChild2.selectOption(age2);

        page.locator(btnDoneTraveler).click();

    }

    public void selectBtnSearch(){
        page.locator(btnSearch).click();
    }



}
