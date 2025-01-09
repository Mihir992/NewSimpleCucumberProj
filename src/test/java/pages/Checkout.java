package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {
    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
    WebElement placeOrderBtn;

    //@FindBy(xpath="//button[contains(@class,'ta-item')])[2]")
    //WebElement selectCountry;

    @FindBy(xpath = "//button[@type='button'][2]")
    WebElement selectItems;

    By results = By.cssSelector(".ta-results");

    public WebDriver driver;
    public WebDriverWait wait;

    public Checkout(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(By Findby)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Findby));
    }

    public void setSelectCountry(String countryName) {
        // Wait for the country input field to be visible
        wait.until(ExpectedConditions.visibilityOf(country));
        country.sendKeys(countryName);
        // Wait for the autosuggestion results to appear
        waitForElementToAppear(results);
        selectItems.click();
    }
    
    public boolean clickPlaceOrder() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
            placeOrderBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(placeOrderBtn));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
