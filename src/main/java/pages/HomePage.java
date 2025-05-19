package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    private String list_menu = "//div[@class='uitk-tabs-container']/ul/li";




    public void setSelectItem(String menu){
        Locator allmenu = page.locator(list_menu);
        List<String> textMenu = allmenu.allTextContents();

        for (int i = 0; i < textMenu.size(); i++) {
            if(textMenu.get(i).equalsIgnoreCase(menu)){
                allmenu.nth(i).click();
                break;
            }
        }
    }
}
