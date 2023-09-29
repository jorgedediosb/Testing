package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    /*  instancia de WebDriver para abrir el sitio web ES CORRECTO???
    public class MiClase {

        public static void main(String[] args) {
            // Establece la ubicación del controlador de Chrome
            System.setProperty("webdriver.chrome.driver", "/Users/jorge/Documents/chromedriver-mac-x64/chromedriver");
    
            // Crea una instancia de WebDriver (ChromeDriver en este caso)
            WebDriver driver = new ChromeDriver();
    
            // Abre el sitio web en el navegador
            driver.get("https://www.google.com/");
    
            // Cierra el navegador
            driver.quit();
        }
    }
    */

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,10);
    }
    
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public void goToLinkText(String LinkText){
        driver.findElement(By.linkText(LinkText)).click();
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement Find(String locator){
        // Espera "explícita" hasta que aparezca el elemento (es mejor que usar el comando sleep, QUE NO DEBE USARSE)
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select (Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));

        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        
        return Find(cellINeed).getText();
    }

    public void setValueFromTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try{
        driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public boolean elementEnable(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }
}
