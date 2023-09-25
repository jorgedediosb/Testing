package steps;

// importamos 'Given', 'When', 'Then', etc. El '*' hace que importe todos de una vez
import cucumber.api.java.en.*;

public class GoogleSteps {

    @Given("^I am on the Google search page$")
    public void navigateTogoogle(){

    }

     @When("^I enter a search criteria$")
    public void enterSearchCriteria(){

    }

     @And("^click on the search button$")
    public void clickSearchButton(){

    }

     @Then("^the results match the criteria$")
    public void validateResults(){

    }
    
}
