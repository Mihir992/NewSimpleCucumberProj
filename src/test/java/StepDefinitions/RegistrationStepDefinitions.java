package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;
import pages.RegistrationCompletePage;
import pages.RegistrationPage;
import Setup.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RegistrationStepDefinitions {
    LandingPage landingPage;
    RegistrationPage registrationPage;
    RegistrationCompletePage registrationCompletePage;

    public WebDriver driver;

    // Cucumber @Before hook to initialize WebDriver
    @Before
    public void setUp() {
        driver = new Setup().initializeDriver();  // assuming Setup class has a method to initialize the driver
    }

    @Given("User go to the letsshop Home page")
    public void user_visited_the_portal() {
        landingPage = new LandingPage(driver);
        landingPage.gotoLandingPage();
    }

    @And("User navigate to the Registration page")
    public void user_clicked_the_registration_link() {
        landingPage = new LandingPage(driver);
        landingPage.gotoRegistrationPage();
    }

    @And("User set first name and last name")
    public void user_sets_the_first_name_and_last_name() {
        registrationPage = new RegistrationPage(driver);

        Random rand = new Random();
        int randomNumForFirstName = rand.nextInt(1000);
        int randomNumForLastName = rand.nextInt(1000);

        String firstName = "firstName" + randomNumForFirstName;
        String lastName = "lastName" + randomNumForLastName;
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
    }

    @And("User set {string} as email")
    public void user_sets_the_email(String email) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.setEmail(email);
    }

    // Add the step definition for setting the phone number
    @And("User set {string} as phoneNumber")
    public void user_sets_the_phone_number(String phoneNumber) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.setPhoneNumber(phoneNumber);  // Assuming there's a method setPhoneNumber in the RegistrationPage class
    }

    @And("User set {string} as password and confirm password again")
    public void user_sets_the_password_and_confirm_password(String password) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.setPassword(password);
    }

    @And("User checked the checkbox")
    public void User_checked_the_checkbox() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickCheckoutBtn();
    }

    @And("User click on the Register button")
    public void user_clicks_the_register_button() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();
    }

    @Then("Verify error message {string} is displayed")
    public void Verify_error_message(String expectedMsg) {
        // Fetch the actual error message from the page
        String actualErrorMessage = registrationPage.getErrorMessage();
        // Assert that the actual error message matches the expected message
        assertEquals("Error message does not match the expected value!", expectedMsg, actualErrorMessage);
    }

    @Then("Verify registration success {string} is displayed")
    public void Verify_success_message(String expectedMsg) {
        // Fetch the actual error message from the page
        String actualErrorMessage = registrationPage.getSuccessMessage();
        // Assert that the actual error message matches the expected message
        assertEquals("Success message does not match the expected value!", expectedMsg, actualErrorMessage);
    }

    // This is a @After hook in Cucumber, which runs after each scenario
    @After
    public void tearDown() {
        // Quit the browser after the scenario
        if (driver != null) {
            driver.quit();
        }
    }
}
