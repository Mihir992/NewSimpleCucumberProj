package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class ProductPage {
       // @FindBy(id = "product_enteredQuantity_20")
        //WebElement productQuantityTextField;
        @FindBy(css = ".card-body button:last-of-type")
        WebElement addToCartButton;
        @FindBy(css = "[routerlink*='cart']")
        WebElement cartPageLink;
        @FindBy(css=".ng-animating")
        WebElement spinner;

        private final WebDriver driver;
        private final WebDriverWait wait;

        public ProductPage(WebDriver driver){
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            PageFactory.initElements(driver, this);
        }

        /*public boolean setQuantity(int quantity){
            try {
                wait.until(ExpectedConditions.visibilityOf(productQuantityTextField));
                productQuantityTextField.clear();
                productQuantityTextField.sendKeys(String.valueOf(quantity));
                return true;
            }catch (Exception ex){
                return false;
            }
        }*/

        public void waitForElementToDisappear(WebElement ele)
        {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOf(ele));
        }

        public boolean clickAddToCart() {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
                addToCartButton.click();
                waitForElementToDisappear(spinner);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

        public boolean clickCartPageLink() {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(cartPageLink));
                cartPageLink.click();
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

    }