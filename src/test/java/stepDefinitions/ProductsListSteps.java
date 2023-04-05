package stepDefinitions;

import browser.Browser;
import io.cucumber.java.en.Then;
import pages.ProductsList;

public class ProductsListSteps {

    @Then("I retrieve the results in report")
    public void iRetrieveTheResultsInReport() {
        Browser.initPage(ProductsList.class).retrieveListOfProducts();

    }
}
