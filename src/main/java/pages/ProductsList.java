package pages;

import browser.Browser;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsList extends Browser {

    @FindBy (xpath = "//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')]/parent::h2/a/span")
    private List<WebElement> productsList;

    public void retrieveListOfProducts() {
        String productText = "";
        for (WebElement product:productsList) {
            productText = productText + "\n" + "," + product.getText();
        }
        ExtentCucumberAdapter.addTestStepLog("The list of products is - "+productText);
    }

}
