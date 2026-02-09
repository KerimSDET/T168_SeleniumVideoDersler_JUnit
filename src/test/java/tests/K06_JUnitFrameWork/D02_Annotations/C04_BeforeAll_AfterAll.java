package tests.K06_JUnitFrameWork.D02_Annotations;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReuseableMethods;

import java.time.Duration;
import java.util.List;

public class C04_BeforeAll_AfterAll {


    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    /*
        Bu gorev icin
        her test method'undan sonra driver'i kapatmak (@AfterEach) mantikli olmaz

        bunun yerine
        class calismaya basladiginda hic bir method calismadan once driver'i olusturmak
        ve tum @Test method'lari calisip bittikten sonra
        calisacak @Test method'u kalmadiginda
        driver'i kapatmak daha mantikli olur

        Bu tur birbirinin sonucuna bagli test method'lari oldugunda
        JUnit ile method'lari tek tek run edebiliriz
        ancak method'un yapmasi gereken islevi yapmasi mumkun olmayabilir

        @BeforeAll ve @AfterAll notasyonu kullanan method'larin
        mutlaka static olmasi gerekir
     */

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

        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test otomasyonu Url Testi PASSED");
        }
//        else System.out.println("Test otomasyonu Url Test FAILED");
        ReuseableMethods.bekle(1);
    }

    @Test
    public void test02(){
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        List<WebElement> bulunanUrunElementList = driver.findElements(By.xpath("//*[@class='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementList.size();

        if (actualSonucSayisi >0){
            System.out.println("Phone arama testi PASSED");
        } else System.out.println("Phone arama testi FAILED");


    }

    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    @Test
    public void test03(){
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        WebElement ilkUrunIsımElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsınIcerik = "phone";
        String actualIsim = ilkUrunIsımElementi.getText().toLowerCase(); //case sensitive olmamasi icin

        if (actualIsim.contains(expectedIsınIcerik)){
            System.out.println("Urun isim testi PASSED");
        } else System.out.println("Urun isim testi FAILED");
    }
}
