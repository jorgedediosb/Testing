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
    // reportes de tests en html (archivo 'src/test/resources/extent.properties'). Hay que añadir las dependencias en build.gradle
    //plugins = "enlace"
    monochrome = true,
    tags = "@Test"
)

public class runner {
    // Cerrar el buscador (Google) después de ejecutar la prueba
    // usar en Terminal: gradle test -Dcucumber.options="--tags @Test""
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}