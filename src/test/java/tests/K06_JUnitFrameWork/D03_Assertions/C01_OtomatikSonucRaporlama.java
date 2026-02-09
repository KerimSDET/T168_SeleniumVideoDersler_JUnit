package tests.K06_JUnitFrameWork.D03_Assertions;

import org.junit.jupiter.api.AfterAll;
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

public class C01_OtomatikSonucRaporlama {


    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    /*
        JUnit bir test method'unun
        PASSED veya FAILED olmasina
        kodlarin sorunsuz olarak calisip bitip bitmemesine gore karar verir

        Biz if-else ile test yaparsak
        if else FAILED yazdirsa bile
        kodlar problem olmadan calismaya devam ettigi icin
        method'un sonunda JUnit test PASSED olarak algilar
        ve yesil tik koyar

        Ozellikle toplu test calistirmalarda
        konsolu inceleyip
        birsuru yazi arasinda
        Test PASSED veya test FAILED sonucunu aramak
        ve kac testin failed oldugunu hesaplamak
        neredeyse imkansizdir

        Eger if ile test yapiyorsak
        ve failed oldugunda JUnit'in de bunu algilamasini istiyorsak
        throw keyword'u ile kontrollu olarak exception olusturabiliriz
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
        else {
            System.out.println("Test otomasyonu Url Test FAILED");
            ReuseableMethods.bekle(1);
            throw new AssertionError("Test otomasyonu Url Test FAILED");
        }
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
