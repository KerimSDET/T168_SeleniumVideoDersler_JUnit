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

public class C03_JUnitAssertions {
    static WebDriver driver;

    @BeforeAll
    public static void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown (){
        ReuseableMethods.bekle(1);
        driver.quit();
    }

    //Testin sorunsuz calismasi icin sirali test yapilmasi gerekir

    @Test
    public void test01(){
        // 1- Test otomasyonu anasayfaya gidin
        //    Url'in testotomasyonu icerdigini test edin

        driver.get("https://www.testotomasyonu.com/");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertNotNull(actualUrl);
        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik),"Url expected veriyi içermez");

//        if (actualUrl.contains(expectedUrl)){
//            System.out.println("Test otomasyonu Url Testi PASSED");
//        }
//        else {
//            System.out.println("Test otomasyonu Url Test FAILED");
//            ReuseableMethods.bekle(1);
//            throw new AssertionError("Test otomasyonu Url Test FAILED");
//        }



    }

    @Test
    public void test02(){
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        List<WebElement> bulunanUrunElementList = driver.findElements(By.xpath("//*[@class='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementList.size();

        Assertions.assertTrue(actualSonucSayisi>0,"Istenen urun bulunamadi");


//        if (actualSonucSayisi >0){
//            System.out.println("Phone arama testi PASSED");
//        } else System.out.println("Phone arama testi FAILED");


    }

    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    @Test
    public void test03(){
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        WebElement ilkUrunIsımElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsınIcerik = "phone";
        String actualIsim = ilkUrunIsımElementi.getText().toLowerCase(); //case sensitive olmamasi icin

        Assertions.assertTrue(actualIsim.contains(expectedIsınIcerik));

//        if (actualIsim.contains(expectedIsınIcerik)){
//            System.out.println("Urun isim testi PASSED");
//        } else System.out.println("Urun isim testi FAILED");
    }
}
