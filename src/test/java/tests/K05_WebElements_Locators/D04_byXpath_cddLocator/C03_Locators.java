package tests.K05_WebElements_Locators.D04_byXpath_cddLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");


        //Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //sayfayi refresh

        driver.navigate().refresh();

        //Sayfa basliginin "Test Otomasyonu" ifadesi icerdiğini test edin

        String expectedTitleIcereik = "Test Otomasyonu";

        String actualTitleIcereik = driver.getTitle();

        if (actualTitleIcereik.contains(expectedTitleIcereik)) {
            System.out.println("Sayfa basligi testi PASSED");
        } else System.out.println("Sayfa basligi testi FAILED");

        //Furniture linkine tiklayin

        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]")).click();

        //price range filtreisnide min degere 40, max degere 200 yazip filtreleyin
        WebElement minKutusu = driver.findElement(By.cssSelector("input[name='min']"));
        minKutusu.clear();
        minKutusu.sendKeys("40");

        WebElement maxKutusu = driver.findElement(By.cssSelector("input[name='max']"));
        maxKutusu.clear();
        maxKutusu.sendKeys("200");

        //filtrele butonuna basalim

        driver.findElement(By.cssSelector("button[name='button']")).click();

        //filtreleme sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.cssSelector("a[class='prod-img']"));

        if (bulunanUrunElementleriList.size() != 0) {
            System.out.println("Urun filtresi testi PASSED");
        } else System.out.println("Urun filtresi testi FAILED");

        //ilk urunu tiklayin
        bulunanUrunElementleriList.get(0).click();

        //urun fiyatinin 40-200 arasinda oldugunu test edin

        WebElement urunFiyatElementi = driver.findElement(By.id("priceproduct"));

        System.out.println(urunFiyatElementi.getText()); //$50.00

        String urunFiyatStr = urunFiyatElementi.getText();

        urunFiyatStr = urunFiyatStr.replaceAll("\\D",""); //5000

        Double urunFiyatiDbl = Double.parseDouble(urunFiyatStr)/100;

        if (urunFiyatiDbl>=40 &&urunFiyatiDbl<=200){
            System.out.println("Urun fiyat testi PASSED");
        } else System.out.println("Urun fiyat testi FAILED");

        driver.quit();

    }
}
