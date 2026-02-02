package tests.K05_WebElements_Locators.D01_WebElemntVeLocatorNedir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_AramaTesti {

    public static void main(String[] args) {


        //1-bir test clasa'i oluşturun.  ilgili ayarlari yapin

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2 https://www.testotomasyonu.com adresine gidin

        driver.get("https://www.testotomasyonu.com/");

        //3- urun arama kutusunu locate edin ve kaydedin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        /*
        kodlariniz ile reel browser'daki bir webelementi kullanabilmek icin
        once o webelementi kodlarimizla tanimlayip
        bir obje olarak class'da kaydetmeliyiz.
         */

        //4- arama kutusuna "shoe" yazdirin

        aramaKutusu.sendKeys("shoe");


        //5- arama islemini yapabilmek icin ENTER tusuna basin

        aramaKutusu.submit();

        //6- sayfayi kapatin

        driver.quit();


    }
}
