package browser;

import driver.support.DriverType;
import driver.support.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class Browser {
    public static WebDriver driver = null;

    public WebDriver getDriver(String browserName) {
        switch (browserName) {
            case "CHROME":
                driver = DriverType.CHROME.getDriver();
                break;
            case "EDGE":
                driver = DriverType.EDGE.getDriver();
                break;
            default:
                Assert.fail("No browser type given");
        }
        return driver;
    }

    public void navigateToUrl() {
        Properties properties = new Properties();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(properties.getApplicationUrl());
        driver.manage().window().maximize();
    }

    public static <T extends Browser> T initPage(Class <T> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

}
