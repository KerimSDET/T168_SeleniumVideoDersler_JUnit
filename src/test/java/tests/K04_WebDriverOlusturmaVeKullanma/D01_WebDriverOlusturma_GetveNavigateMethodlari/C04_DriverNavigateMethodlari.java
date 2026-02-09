
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(1000);

        //driver.get("https://www.kancaendustriyel.com");
        driver.navigate().to("https://www.kancaendustriyel.com");
        //driver.get ile aynı işlemi yapar

        Thread.sleep(1000);

        driver.navigate().back();
        //testotomasyonu.com sayfasına donun

        Thread.sleep(1000);

        driver.navigate().forward();
        //yenidne kanca sayfasına git

        Thread.sleep(1000);

        driver.quit();



    }

}
