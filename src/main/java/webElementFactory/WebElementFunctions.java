package webElementFactory;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WebElementFunctions extends Browser {
    public int countNumberOfElementsByXPath (String xPath, String oldCharacter, String valueToBeReplaced) {
        List<WebElement> webElementList = driver.findElements(By.xpath(xPath));
        return webElementList.size();
    }

    public List<WebElement> returnElementList(String xPath, String oldCharacter, String valueToBeReplaced) {
        xPath = xPath.replace(oldCharacter, valueToBeReplaced);
        List<WebElement> webElementList = driver.findElements(By.xpath(xPath));
        if (webElementList.size() == 0) {
            Assert.fail("The element is not present on the page");
        }
        return webElementList;
    }
}
