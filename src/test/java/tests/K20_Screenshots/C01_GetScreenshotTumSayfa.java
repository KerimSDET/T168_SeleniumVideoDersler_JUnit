package tests.K20_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class C01_GetScreenshotTumSayfa extends TestBase_Each {

    @Test
    public void test01() throws IOException {

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

        // tum sayfanin screenshot'ini alin

        // 1.adim tss objesi olusturalim

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        String filePath = "target/screenshots/allScreenShot1.jpg";

        File newScreenshot = new File(filePath);

        // 3.adim screenshot'i alip gecici bir dosya olarak kaydedelim

        File geciciFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciFile,newScreenshot);


    }
}
