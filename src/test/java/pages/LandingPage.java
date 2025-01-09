package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    @FindBy(xpath = "//a[text()='Register here']")
    WebElement registerLink;
    //@FindBy(xpath = "//ul[@class='top-menu notmobile']/descendant::a[contains(text(),'Electronics')]")
    //WebElement eletronicsTab;
    //@FindBy(xpath = "//ul[@class='top-menu notmobile']/descendant::a[contains(text(),'Cell phones')]")
    //WebElement cellPhoneTab;

    public WebDriver driver;
    public WebDriverWait wait;

    public LandingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public boolean gotoLandingPage(){
        try {
            String landingPageUrl = "https://rahulshettyacademy.com/client/";
            driver.get(landingPageUrl);
            wait.until(ExpectedConditions.elementToBeClickable(registerLink));
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean gotoRegistrationPage(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(registerLink));
            registerLink.click();
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    /*public boolean hoverElectronicsTab(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(eletronicsTab));
            Actions actions = new Actions(driver);
            actions.moveToElement(eletronicsTab).perform();
            return true;
        }catch (Exception ex){
            return false;
        }
    }*/
}
