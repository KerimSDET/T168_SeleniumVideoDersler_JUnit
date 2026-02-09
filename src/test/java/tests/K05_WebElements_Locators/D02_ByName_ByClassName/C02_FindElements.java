package tests.K05_WebElements_Locators.D02_ByName_ByClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_FindElements {


    public static void main(String[] args) {


        // 1- Bir test class'i olusturun ve ilgili ayarlari yapiniz

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // 2- https://www.testotomasyonu.com/ adresine gidiniz

        driver.get("https://www.testotomasyonu.com");


        // 3- arama kutusunua phone yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // 4- Category bolumunde 8 element oldugunu test edin

        List<WebElement> categoriElementleriList = driver.findElements(By.className("panel-list"));

        int expectedCategoryElementSayisi = 8;
        int actualCategoryElementSayisi = categoriElementleriList.size();

        if (actualCategoryElementSayisi == expectedCategoryElementSayisi) {
            System.out.println("Category element sayisi Testi PASSED");
        } else System.out.println("Category element sayisi Testi FAILED");


        // 5- Categort isimlerini yazdirin

        //System.out.println(categoriElementleriList);  //istediğimiz veriyi vermiyor referansları yazdırdı

        for (int i = 0; i < categoriElementleriList.size(); i++) {

            System.out.println(categoriElementleriList.get(i).getText());
        }


        /*
        Grocery

        Travel
        Furniture
        Shoes
        Men Fashion
        Women Fashion
        Electronics
         */

        // 6- Sayfayi kapain.

        driver.quit();



    }
}
