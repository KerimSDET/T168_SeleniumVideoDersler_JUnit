package tests.K06_JUnitFrameWork.D02_Annotations;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReuseableMethods;

import java.time.Duration;

public class C02_SetupVeTearDownMethodOlusturma {


    WebDriver driver;


    public void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void teardown (){
        ReuseableMethods.bekle(1);
        driver.quit();
    }

    @Test
    public  void wiseQuarterTesti (){

        //2.method wisequarter anasayfaya gidin
        //          url'in wisequarter icerdigini test edin

        setup();

//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedUrlIcerik)) {
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");

//        ReuseableMethods.bekle(1);
//        driver.quit();
        teardown();
    }

    @Test
    public  void junitTesti (){

        // 3.method junit.org adresine gidin
        //          url'in "https://junit.org/junit5/" oldugunu test edin
        setup();

//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.junit.org");

        String expectedUrl = "https://junit.org/junit5/";
        String actualURL = driver.getCurrentUrl();

        if (expectedUrl.equals(actualURL)) {
            System.out.println("JUnit Testi PASSED");
        } else System.out.println("JUnit testi FAILED");

        //        ReuseableMethods.bekle(1);
//        driver.quit();
        teardown();


    }

    @Test
    public  void testOtomasyonuTest (){
        // 1.method testotomasyonu anasayfaya gidin
        //          title'in Test Otomasyonu icerdigini test edin
        setup();

//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("Test Otomasyonu testi PASSED");
        } else System.out.println("Test Otomasyonu testi FAILED");

//        ReuseableMethods.bekle(1);
//        driver.quit();
        teardown();

    }


}
