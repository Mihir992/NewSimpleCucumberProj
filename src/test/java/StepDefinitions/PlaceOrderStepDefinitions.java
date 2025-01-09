package StepDefinitions;

import Setup.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

public class PlaceOrderStepDefinitions{
    LandingPage landingPage;
    LoginPage login;
    ProductPage productPage;
    CartPage cartPage;
    Checkout checkoutPage;
    ConfirmOrderPage confirmOrder;

    public WebDriver driver;

    // Cucumber @Before hook to initialize WebDriver
    @Before
    public void setUp() {
        driver = new Setup().initializeDriver();  // assuming Setup class has a method to initialize the driver
    }

    @Given("User go to the Home page for test 2")
    public void user_visited_the_portal() {
        landingPage = new LandingPage(driver);
        landingPage.gotoLandingPage();
    }

    @When("User enters valid username and password and clicks login button")
    public void User_enters_valid_username_and_password_and_clicks_login_button() {
        login = new LoginPage(driver);
        login.setEmail("testuser01@yopmail.com");
        login.setPassword("Test@123");
        login.clickLoginButton();
    }

    @And("User click on the add to cart button")
    public void User_click_on_the_add_to_cart_button() {
        productPage = new ProductPage(driver);
        productPage.clickAddToCart();
    }

    @And("User go to the shipping cart page")
    public void User_go_to_the_shipping_cart_page() {
        productPage = new ProductPage(driver);
        productPage.clickCartPageLink();
    }

    @And("User click on checkout button")
    public void User_click_on_checkout_button() {
        cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
    }

    /*@And("User input all the billing details and click continue")
    public void user_input_all_the_billing_details_and_click_continue() {
        billingPage = new BillingPage(driver);
        billingPage.setBillingData(
                "John" + (int)(Math.random() * 100),
                "Doe" + (int)(Math.random() * 100),
                "john.doe" + (int)(Math.random() * 1000) + "@example.com",
                "Company" + (int)(Math.random() * 100),
                "Bangladesh",
                "Other",
                "City" + (int)(Math.random() * 100),
                "Address1-" + (int)(Math.random() * 1000),
                "Suite " + (int)(Math.random() * 10),
                "ZIP" + (int)(Math.random() * 9000 + 1000),
                "555-" + (int)(Math.random() * 900 + 100) + "-" + (int)(Math.random() * 9000 + 1000),
                "Fax" + (int)(Math.random() * 900 + 100) + "-" + (int)(Math.random() * 9000 + 1000)
        );
    }*/

    // Step definition for selecting a country
    @And("User selects {string} as the country")
    public void user_selects_country(String country) {
        checkoutPage = new Checkout(driver);
        checkoutPage.setSelectCountry(country);
    }

    @And("User click on place order button to place the order")
    public void User_click_on_place_order_button_to_place_the_order() {
        checkoutPage = new Checkout(driver);
        checkoutPage.clickPlaceOrder();
    }

    @Then("Verify that the order place message \" Thankyou for the order. \" is displayed")
    public void verify_that_the_order_has_been_successfully_processed() {
        confirmOrder = new ConfirmOrderPage(driver);
        confirmOrder.verifyConfirmationMessage();
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