package Setup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Setup {
    // Declare WebDriver as static to maintain a single instance
    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        if (driver == null) {  // Check if driver is already initialized
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
        return driver;
    }

    // This will run after each scenario to quit the WebDriver
    @After
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set to null after quitting the driver
        }
    }

    // Getter for the WebDriver instance
    public static WebDriver getDriver() {
        return driver;
    }
}
