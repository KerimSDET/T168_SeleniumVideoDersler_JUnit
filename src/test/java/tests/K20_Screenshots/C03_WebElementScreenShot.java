package tests.K20_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C03_WebElementScreenShot extends TestBase_Each {


    @Test
    public void C03_WebElementScreenShot() throws IOException {

        // Testotomasyonu anasayfaya gidelim
        driver.get("https://www.testotomasyonu.com");

        // Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();

        // Kullanici adi olarak wise@gmail.com girin
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys("wise@gmail.com");

        // password olarak 12345 girin
        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("12345");


        // sign in butonuna basarak sisteme giris yapin
        driver.findElement(By.id("submitlogin")).click();

        // giris yapilabildigini test etmek icin
        // Logout butonunun gorunur oldugunu test edin
        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButton.isDisplayed());

        //logout butonunun resmini çekin

        // 1.adim screenshot alacagimiz webelementi locate edip kaydedelim
        //        biz yukarda Logout butonunu locate ettik

        // 2.adim resmi kaydedecegimiz File'i olusturalim

        String filePaath = "target/screenshots/webElementResmi.jpeg";
        File webElementResimCek = new File(filePaath);

        // 3.adim webElement'i kullanarak screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = logoutButton.getScreenshotAs(OutputType.FILE);


        // 4.adim gecici dosyayi asil dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,webElementResimCek);


        // logout butonuna basarak sistemden cikis yapin

        logoutButton.click();






    }


}
