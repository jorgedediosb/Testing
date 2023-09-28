package steps;

import org.junit.Assert;

// importamos 'Given', 'When', 'Then', etc. El '*' hace que importe todos de una vez
import cucumber.api.java.en.*;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    // con ^ y $ decimos a cucumber que este paso es "sólo esto"
    @Given("^I am on the Google search page$")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("^I enter a search criteria$")
    public void enterSearchCriteria(){
        google.enterSearchCriteria("Google");
    }

    @And("^click on the search button$")
    public void clickSearchButton(){
        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria$")
    public void validateResults(){
        Assert.assertEquals("texto que validamos", google.firstResult());
    }
    
}
