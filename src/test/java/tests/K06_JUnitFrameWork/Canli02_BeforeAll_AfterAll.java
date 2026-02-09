package tests.K06_JUnitFrameWork;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReuseableMethods;

import java.time.Duration;

public class Canli02_BeforeAll_AfterAll {

// 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin    
// 1- Test otomasyonu anasayfaya gidin    
//     Url'in testotomasyonu icerdigini test edin    
// 2- phone icin arama yapin    
//     ve arama sonucunda urun bulunabildigini test edin    
// 3- ilk urunu tiklayin    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Setup çalıştı");
        }

        @AfterEach
        public void teardown (){
                ReuseableMethods.bekle(1);
                driver.quit();
            }

    @Test
    public void test01(){
        // 1- Test otomasyonu anasayfaya gidin
        // driver.get("https://www.testotomasyonu.com");
        //  Url'in testotomasyonu icerdigini test edin

        String expectedurlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedurlIcerik)){
            System.out.println("Url testi PASSED");
        }
        ReuseableMethods.bekle(1);
    }
    }





