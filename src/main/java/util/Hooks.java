package util;

import browser.Browser;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void closeWebDriver() {
        Browser.driver.close();
        Browser.driver.quit();
    }
}
