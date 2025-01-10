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
    WebElement countryInput;

    @FindBy(xpath = "//button[contains(@class, 'ng-star-inserted')]")
    WebElement countrySuggestions;

    @FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
    WebElement placeOrderBtn;

    //@FindBy(xpath="//button[contains(@class,'ta-item')])[2]")
    //WebElement selectCountry;

    //@FindBy(xpath = "//button[contains(@class, 'ng-star-inserted') and contains(text(), 'India')]")
    //WebElement selectItems;

    By results = By.cssSelector(".ta-results");

    public WebDriver driver;
    public WebDriverWait wait;

    public Checkout(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(By Findby)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Findby));
    }

    public void setSelectCountry(String countryName) {
        // Wait for the country input field to be visible
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(countryInput));
        countryInput.sendKeys(countryName);
        // Wait for the autosuggestion results to appear
       // waitForElementToAppear(results);
        // Wait for the autosuggestion results to appear
        wait.until(ExpectedConditions.visibilityOf(countrySuggestions));

        // Construct the dynamic XPath for the specific country suggestion
        WebElement countryButton = driver.findElement(By.xpath("//button[contains(@class, 'ng-star-inserted') and contains(text(), '" + countryName + "')]"));

        // Select the country from the suggestions list
        countryButton.click();
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
