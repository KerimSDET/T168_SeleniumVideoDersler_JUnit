package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NAvigateMethodariTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //1- youtube sayfasına gidiniz. https://www.youtube.com

        driver.get("https://www.youtube.com/");


        //2- URL'İN "youtube" içerdiğini test edin

        String expectedUrlIcerik =   "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("URL Test PASSED");
        } else  {
            System.out.println("URL Test FAILED");
        }

        //3- Testotomasyonu sayfasina gidiniz. https:www.testotomasyonu.com

        driver.get("https://www.testotomasyonu.com/");


        //4- Title'in  "Test Otomasyonu" içerdiğini test ediniz.

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("Title Test PASSED");
        } else System.out.println("Title Test FAILED");

        //5- Tekrar Youtube sayfasına gidin

        driver.navigate().back();

        Thread.sleep(2000);

        //6- Title'in Youtube olduğunu test edin.

        String expectedTitle = "YouTube";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Youtube Title Test PASSED");
        } else System.out.println("Youtube Title Test FAILED");

        //7- Sayfayı Refresh (yenile) yapın

        driver.navigate().refresh();

        //8- Sayfayı kapatalım / Tum sayfaları kapatın


        Thread.sleep(2000);
        driver.quit();


    }
}
