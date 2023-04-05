package driver.support;

import browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverFunctions extends Browser {
    public void waitForElement(WebElement element, String timeOutInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeOutInSeconds)));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
