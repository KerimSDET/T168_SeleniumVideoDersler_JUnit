package tests.K04_WebDriverOlusturmaVeKullanma.D02_farkliWebDriverKullanma;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_FarkliWebDriverKullanma {
    public static void main(String[] args) {

        //WebDriver driver = new ChromeDriver(); normal kullanım

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.get("https://www.testotomasyonu.com/");

        driver.quit();


    }
}
