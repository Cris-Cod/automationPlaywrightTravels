package utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

public class BaseTest {

    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext browserContext;
    protected Page page;

    public void launchPage(String browserName, String headless, String url){
        playwright = Playwright.create();
        if(browserName.equalsIgnoreCase("chrome")){
            browserType = playwright.chromium();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            browserType = playwright.firefox();
        } else if (browserName.equalsIgnoreCase("edge")) {
            browserType = playwright.webkit();
        }

        if(headless.equalsIgnoreCase("true")){
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(true));
        }else {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false));
        }
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1200,800));
        browserContext.close();
        System.out.println("Browser name: " + browserName + " Version: " + browser.version());

        page = browser.newPage();
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.LOAD));
    }

    public void closePage(){
        page.close();
        browser.close();
        playwright.close();
    }
}
