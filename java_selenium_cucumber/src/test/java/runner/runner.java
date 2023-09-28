package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    tags = "@Test"
)

public class runner {
    // Cerrar el buscador (Google) después de ejecutar la prueba
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}