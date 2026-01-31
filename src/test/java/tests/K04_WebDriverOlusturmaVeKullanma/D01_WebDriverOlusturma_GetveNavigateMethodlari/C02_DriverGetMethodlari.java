package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com/");

        System.out.println(driver.getTitle()); //Test Otomasyonu - Test Otomasyonu
        //sayfanın başlığını (Title) getirir.

        System.out.println(driver.getCurrentUrl()); //https://www.testotomasyonu.com/
        //gidilen sayfadaki actual url'yi getirir.

        //System.out.println(driver.getPageSource()); //tüm sayfa kaynağını getirir.

        System.out.println(driver.getWindowHandle()); //0481E3C13CA8081D5B0E2326157EDB03
        System.out.println(driver.getWindowHandles()); //[0481E3C13CA8081D5B0E2326157EDB03]

        Thread.sleep(3000);
        //driver.close();
        driver.quit();

        /*
        driver.close() açtığımız driver'i kapatır. birden fazla window varsa son açık olanı kapatır.
        driver.quit ise test sirasinda birden fazla window acilsa da hepsini kapatir.
        yani tarayiciyi kapatir.
         */



    }
}
