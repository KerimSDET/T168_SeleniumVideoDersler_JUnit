package tests.K06_JUnitFrameWork.D03_Assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReuseableMethods;

import java.time.Duration;
import java.util.List;

public class C04_BeforeVeAfterSartMi {

    // tek test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in test otomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    @Test
    public void urunAramaTesti()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1- Test otomasyonu anasayfaya gidin
        //    Url'in testotomasyonu icerdigini test edin

        driver.get("https://www.testotomasyonu.com/");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertNotNull(actualUrl);
        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik),"Url expected veriyi içermez");

        ReuseableMethods.bekle(1);

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        List<WebElement> bulunanUrunElementList = driver.findElements(By.xpath("//*[@class='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementList.size();

        Assertions.assertTrue(actualSonucSayisi>0,"Istenen urun bulunamadi");

        ReuseableMethods.bekle(1);

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        WebElement ilkUrunIsımElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsınIcerik = "phone";
        String actualIsim = ilkUrunIsımElementi.getText().toLowerCase(); //case sensitive olmamasi icin

        Assertions.assertTrue(actualIsim.contains(expectedIsınIcerik));

        ReuseableMethods.bekle(1);

        driver.quit();

    }
}
