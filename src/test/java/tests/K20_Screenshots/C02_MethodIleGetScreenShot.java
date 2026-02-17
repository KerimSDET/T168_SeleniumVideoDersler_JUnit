package tests.K20_Screenshots;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

import java.io.IOException;

public class C02_MethodIleGetScreenShot extends TestBase_Each {

    @Test
    public void test02() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);


        // arama sonucunda urun bulunabildigini test edin
        WebElement searchFoundElement = driver.findElement(By.className("product-count-text"));

        String unExpResultText = "0 Product Found";
        String actualResultText = searchFoundElement.getText();

        Assertions.assertNotEquals(unExpResultText, actualResultText);

        ReuseableMethods.bekle(1);

        //tum sayfa sreenshot al

        ReuseableMethods.tumSayfaResimCek(driver);
        //her seferinde verdiğimiz isim olan tumSayfaResmi.jpeg olarak üstüne kaydeder

        ReuseableMethods.tumSayfaResimCek(driver,"aramatesti1602");

        //ilk urunu tikla

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        //acilan sayfada phone oldugunu dogurla cS olmadan
        WebElement ilkUrunismi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expIsimIcerik = "phone";
        String actIsimIcerik = ilkUrunismi.getText().toLowerCase();

        Assertions.assertTrue(actIsimIcerik.contains(expIsimIcerik));

        //saffa goruntusunu alin
        ReuseableMethods.tarihliTumSayfaResimCek(driver);

        ReuseableMethods.tarihliTumSayfaResimCek(driver,"tarihliaramatesti");

        ReuseableMethods.tumSayfaResimCek(driver,"aramatesti1602");

        ReuseableMethods.tumSayfaResimCek(driver);

    }
}
