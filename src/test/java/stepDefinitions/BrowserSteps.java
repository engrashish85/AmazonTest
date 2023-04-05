package stepDefinitions;

import browser.Browser;
import io.cucumber.java.en.Given;

public class BrowserSteps extends Browser {

    @Given("Browser {string} is invoked")
    public void browserIsInvoked(String browserName) {
        Browser browser = new Browser();
        browser.getDriver(browserName.toUpperCase());
        browser.navigateToUrl();
    }
}
