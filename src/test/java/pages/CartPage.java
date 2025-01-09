package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class CartPage {
        @FindBy(css=".totalRow button")
        WebElement checkoutButton;

        public WebDriverWait wait;

        public CartPage(WebDriver driver) {
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            PageFactory.initElements(driver, this);
        }

        /*public boolean clickTermsAndConditionsCheckbox() {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(termsAndConditionsCheckbox));
                if(!termsAndConditionsCheckbox.isSelected()){
                    termsAndConditionsCheckbox.click();
                }
                return true;
            } catch (Exception ex) {
                return false;
            }
        }*/

        public boolean clickCheckoutButton() {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
                checkoutButton.click();
                wait.until(ExpectedConditions.invisibilityOf(checkoutButton));
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }