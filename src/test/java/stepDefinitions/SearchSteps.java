package stepDefinitions;

import browser.Browser;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.SearchPage;

public class SearchSteps extends Browser {

    private static final String searchTitle = "Amazon.com.au: Shop online for Electronics, Apparel, Toys, Books, DVDs & more";

    @Given("a user is on Amazon search page")
    public void aUserIsOnAmazonSearchPage() {
        Browser browser = new Browser();
        String title = driver.getTitle();
        if (title.isEmpty()) {
            browser.navigateToUrl();
        }
        Assert.assertEquals(driver.getTitle(), searchTitle,
                "Validating that title is matching successfully with the amazon search page");
        ExtentCucumberAdapter.addTestStepLog("User successfully navigated to search page");
    }

    @And("I search the amazon application with {string}")
    public void iSearchTheAmazonApplicationWith(String searchText) {
        new SearchPage().searchAmazonPortal(searchText);
    }

    @And("I filter with {string},{string} and {string}")
    public void iFilterWithAnd(String brand, String resolution, String year) {
        new SearchPage().setFiltersForTelevision(brand, resolution, year);
    }

    @And("I sort the results")
    public void iSortTheResults() {
        Browser.initPage(SearchPage.class).sortResults();
    }

}
