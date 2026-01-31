package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_WEbDriver_FarkliKullanma {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

       driver.get("https://www.google.com");
       driver.get("https://www.testotomasyonu.com/");

                driver.quit();

    }
}
