package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class C01_WebDriverTest {

    @Test
    public void googleTest() {
        WebDriver driver = DriverFactory.createChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }
}

