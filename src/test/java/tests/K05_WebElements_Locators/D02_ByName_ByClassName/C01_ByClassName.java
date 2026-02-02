package tests.K05_WebElements_Locators.D02_ByName_ByClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C01_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class'i oluşturun ilgili ayarları yapın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- https://www.testotomasyonu.com adresine gidin

        driver.get("https://www.testotomasyonu.com");

        //3- urun arama kutusunu locate edin

        //WebElement aramaKutusu = driver.findElement(By.name("search"));
        WebElement aramaKutusu = driver.findElement(By.className("search-input"));

        //4- arama kutusuna "shoe" yazdirin
        aramaKutusu.sendKeys("shoe");

        //5- arama işlemini yapabilmek için ENTER tuşuna basın
        aramaKutusu.submit();

        //6- arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        System.out.println(aramaSonucElementi);
        // [[ChromeDriver: chrome on windows (c2c33b1dac958b1d1d3553a06083e160)] -> class name: product-count-text]

        System.out.println(aramaSonucElementi.getText()); //4 Products Found

        String aramaSonucuStr = aramaSonucElementi.getText(); //"4 Products Found"
        //sınuc yazisindaki sayi olmayan herseyi yokedelim

        aramaSonucuStr = aramaSonucuStr.replaceAll("\\D", ""); //"4"

        //String 4 ü matematik işlemi içn int a cevirmeliyiz

        int aramaSonucuSayisiInt =  Integer.parseInt(aramaSonucuStr);

        if (aramaSonucuSayisiInt >= 1) {
            System.out.println("Arama  Testi PASSED");
        } else System.out.println("Arama  Testi FAILED");
//        4 Products Found
//        Arama  Testi PASSED




        driver.quit();





    }
}
