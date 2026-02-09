package tests.K09_JsAllerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C02_JsAlerts extends TestBase_Each {

    //3 test method'u olusturup asagidaki gorevi tamamlayin
    /*
        Bir webelement'e click yaptigimizda
        driver objesi ortam degisikligi beklemez

        ayni window'da kalip, farkli bir url'e gitmeyi bekler

        ANCAAKKKK bazi islemler yapildiginda
        farkli bir ortam olusabilir

        driver'i bu farkli ortama gecirmek icin
        driver.switchTo() kullanmamiz gerekir

        Bu durumlardan birisi JavaScript alert'lerdir.
        JsAlert calistiginda normal window uzerinde islem yapamayiz
        sag tus yapip locate alamadigimiz icin alert uzerinde driver'i calistiramayiz

        driver'in jsAlert'e gecmesi ve orada islem yapabilmesi icin
        oncelikle jsAlert evrenine switch yapmasi gerekir
     */

    //1. Test
    @Test
    public void C01_JSAlerts(){
//	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

//	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertText, actualAlertText);

//	-  OK tusuna basip alert'i kapatin

        driver.switchTo().alert().accept();
    }



    //2.Test
    @Test
    public void C02_JSAlerts(){
//	- https://testotomasyonu.com/javascriptAlert adresine gidin
     driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String expectedResultText ="You clicked: Cancel";
        String actualResultText = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedResultText, actualResultText);
        }

    //3.Test
    @Test
    public void C03_JSAlerts(){
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        //	- Cikan prompt ekranina "Cansu" yazdiralim
        driver.switchTo().alert().sendKeys("Cansu");
        ReuseableMethods.bekle(2);
//	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin Cansu icerdigini test' edelim
        String expectedResultText = "Cansu";
        String actualResultText = driver.findElement(By.id("result")).getText();

        Assertions.assertTrue(actualResultText.contains(expectedResultText));
        ReuseableMethods.bekle(3);

    }


}
