package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(id = "userEmail")
    WebElement emailTextField;

    @FindBy(id = "userPassword")
    WebElement passwordTextField;

    @FindBy(id = "login")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email){
            wait.until(ExpectedConditions.visibilityOf(emailTextField));
            emailTextField.sendKeys(email);
    }

    public void setPassword(String password) {
            wait.until(ExpectedConditions.visibilityOf(passwordTextField));
            passwordTextField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginBtn.click();
    }
}
