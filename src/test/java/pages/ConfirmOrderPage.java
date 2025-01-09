package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmOrderPage {

    @FindBy(css=".hero-primary")
    WebElement confirmationMessage;

    public WebDriverWait wait;

    public ConfirmOrderPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // Expected confirmation message
    private static final String EXPECTED_CONFIRMATION_MESSAGE = "THANKYOU FOR THE ORDER.";

    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }

    public void verifyConfirmationMessage() {
        String confirmMessage = getConfirmationMessage();
        Assert.assertEquals(confirmMessage, EXPECTED_CONFIRMATION_MESSAGE, "Confirmation message does not match expected.");
    }

}
