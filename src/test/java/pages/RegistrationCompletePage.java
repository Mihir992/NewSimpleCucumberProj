package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationCompletePage {

    @FindBy(xpath = "//h1[text()='Account Created Successfully']")
    WebElement registrationResultText;

    public WebDriver driver;
    public WebDriverWait wait;

    public RegistrationCompletePage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public String verifyRegistrationText() {
            // Wait until the element is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(registrationResultText));

            // Retrieve and return the text of the element
            String resultText = registrationResultText.getText();
            System.out.println("Registration result: " + resultText);
            return resultText;
        }
    }
