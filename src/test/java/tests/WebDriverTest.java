package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class WebDriverTest {

    @Test
    void googleTest() {
        WebDriver driver = DriverFactory.createChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }
}
