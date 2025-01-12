package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    @FindBy(id = "firstName")
    WebElement firstNameTextField;
    @FindBy(id = "lastName")
    WebElement lastNameTextField;
    @FindBy(id = "userEmail")
    WebElement emailTextField;
    @FindBy(id = "userMobile")
    WebElement phoneNumberTextField;
    @FindBy(id = "userPassword")
    WebElement passwordTextField;
    @FindBy(id = "confirmPassword")
    WebElement confirmPasswordTextField;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkboxField;
    @FindBy(id = "login")
    WebElement registerButton;
    @FindBy(xpath = "//div[contains(text(),'*Email is required')]")
    WebElement errorMessage;
    @FindBy(xpath = "//h1[contains(text(),'Account Created Successfully')]")
    WebElement successMessage;

    private final WebDriverWait wait;

    public RegistrationPage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    /*public boolean setGender(String gender){
        try {
            WebElement genderRadioButton = "male".equalsIgnoreCase(gender) ? genderMaleRadioButton : genderFemaleRadioButton;
            wait.until(ExpectedConditions.elementToBeClickable(genderRadioButton));
            genderRadioButton.click();
            return true;
        }catch (Exception ex){
            return false;
        }
    }*/

    public boolean setFirstName(String firstName){
        try {
            wait.until(ExpectedConditions.visibilityOf(firstNameTextField));
            firstNameTextField.sendKeys(firstName);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean setLastName(String lastName){
        try {
            wait.until(ExpectedConditions.visibilityOf(lastNameTextField));
            lastNameTextField.sendKeys(lastName);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    /*public boolean setDob(String dob){
        try {
            String[] dobParts = dob.split("/");
            wait.until(ExpectedConditions.elementToBeClickable(dayOfBirthSelect));
            dayOfBirthSelect.sendKeys(dobParts[0]);

            wait.until(ExpectedConditions.elementToBeClickable(monthOfBirthSelect));
            monthOfBirthSelect.sendKeys(dobParts[1]);

            wait.until(ExpectedConditions.elementToBeClickable(yearOfBirthSelect));
            yearOfBirthSelect.sendKeys(dobParts[2]);
            return true;
        }catch (Exception ex){
            return false;
        }
    }*/

    public boolean setEmail(String email){
        try {
            wait.until(ExpectedConditions.visibilityOf(emailTextField));
            emailTextField.sendKeys(email);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean setPhoneNumber(String phoneNumber){
        try {
            wait.until(ExpectedConditions.visibilityOf(phoneNumberTextField));
            phoneNumberTextField.sendKeys(phoneNumber);
            return true;
        }catch (Exception ex){
            return false;
        }
    }


    public boolean setPassword(String password){
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordTextField));
            passwordTextField.sendKeys(password);

            wait.until(ExpectedConditions.visibilityOf(confirmPasswordTextField));
            confirmPasswordTextField.sendKeys(password);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean clickCheckoutBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkboxField));
            checkboxField.click();
           // wait.until(ExpectedConditions.invisibilityOf(checkoutAsGuestButton));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    public boolean clickRegisterButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(registerButton));
            registerButton.click();
            wait.until(ExpectedConditions.invisibilityOf(registerButton));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // Method to fetch the actual error message
    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            // Fetch and log the actual error message
            String errorMsg = errorMessage.getText().trim();
            System.out.println("Error Message: " + errorMsg);  // Log for debugging
            return errorMsg;
        } catch (Exception ex) {
            return ""; // Return an empty string if no error message is found
        }
    }

    // Method to fetch the actual success message
    public String getSuccessMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            // Fetch and log the actual success message
            String actualSuccessMessage = successMessage.getText().trim();
            System.out.println("Actual Success Message: " + actualSuccessMessage);  // Log for debugging
            // Return the success message text
            return actualSuccessMessage;
            } catch (Exception ex) {
            return ""; // Return an empty string if no error message is found
        }
    }
}
