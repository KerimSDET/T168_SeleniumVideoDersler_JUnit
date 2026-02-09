package tests.K11_IFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class C01_IFrame extends TestBase_Each {

    @Test
    public void test01() {
        //1) https://demoqa.com/frames sitesine gidiniz
        driver.get("https://demoqa.com/frames");


        //2) This is a sample page yazisinin gorunur oldugunu test edin
       //once iframe Webelement ile locate edelim
        WebElement hedefIframeElementi = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(hedefIframeElementi);

        WebElement yaziElementi = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));

        Assertions.assertTrue(yaziElementi.isDisplayed());
                /*
                yaziyi unique olarak locate etmemize ragmen kullanamadik
                 HTML kodlarini inceleyince kullanmak istedigimiz webelementin
                 bir iframe(gomulu HTML sayfa) icerisinde oldugunu belirledik
                 bir iframe icerisindeki elementi kullanabilmek icin
                 once o iframe'e gecis yapmamiz gerekir
             */
        //3) TOOLSQA logosunun gorunur oldugunu test edin

        /*
            iframe icine gecis yapinca , biz driver'i oradan cikarincaya kadar
            driver iframe'in icinde kalir
            driver'i icinde oldugu iFrame'den cikarmak icin iki farkli method kullanilabilir

            driver.switchTo().parentFrame();
            ic ice birden fazla katman olarak iFrame'ler varsa
            bir ust katman'a cikartir

            driver.switchTo().defaultContent();
            ic ice birden fazla katman olarak iFrame'ler varsa
            direk anasayfaya cikartir
         */

        driver.switchTo().defaultContent();
        WebElement toolsQALogo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
        Assertions.assertTrue(toolsQALogo.isDisplayed());

        //4) sayfadaki iframe sayısını yazdirin.

        List<WebElement> iframeListesi = driver.findElements(By.tagName("iframe"));
        System.out.println(iframeListesi.size());

    }
}
