package pages;

import browser.Browser;
import driver.support.WebDriverFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webElementFactory.WebElementFunctions;

import java.util.List;

public class SearchPage extends Browser {

    @FindBy (id = "twotabsearchtextbox")
    private WebElement amazonSearchBox;

    @FindBy (id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy (xpath = "//div[@class='a-section a-spacing-none s-messaging-widget-results-header']")
    private WebElement results;

    @FindBy (xpath = "//span[@class='a-dropdown-prompt'][text()='Featured']")
    private WebElement sortButton;

    @FindBy (xpath = "//a[text()='Price: Low to High']")
    private WebElement lowToHighDropdownButton;

    private static String brandFilterXpath = "//div[@id='brandsRefinements']/child::ul/child::li[@aria-label='^']//i";
    private static String televisionResolutionXpath = "//div[@id='filters']//span[text()='Resolution']/following::ul[1]/child::li[@aria-label='^']//i";
    private static String modelYearXpath = "//div[@id='filters']//span[text()='Model Year']/following::ul[1]/child::li[@aria-label='^']//i";

    public void searchAmazonPortal(String valueToBeSearched) {
        SearchPage searchPage = Browser.initPage(SearchPage.class);
        searchPage.amazonSearchBox.sendKeys(valueToBeSearched);
        searchPage.searchButton.click();
        new WebDriverFunctions().waitForElement(searchPage.results, "20");
    }

    public void setFiltersForTelevision(String brand, String resolution, String year) {
        try {
            WebElementFunctions webElementFunctions = new WebElementFunctions();
            List<WebElement> brandElement = webElementFunctions.returnElementList(brandFilterXpath, "^", brand);
            brandElement.get(0).click();
            List<WebElement> resolutionElement = webElementFunctions.returnElementList(televisionResolutionXpath, "^", resolution);
            resolutionElement.get(0).click();
            List<WebElement> yearElement = webElementFunctions.returnElementList(modelYearXpath, "^", year);
            yearElement.get(0).click();
        } catch (Exception e) {
            driver.close();
            driver.quit();
            e.printStackTrace();
        }
        new WebDriverFunctions().waitForElement(Browser.initPage(SearchPage.class).results, "20");
    }

    public void sortResults() {
        SearchPage searchPage = Browser.initPage(SearchPage.class);
        searchPage.sortButton.click();
        searchPage.lowToHighDropdownButton.click();
    }

}
