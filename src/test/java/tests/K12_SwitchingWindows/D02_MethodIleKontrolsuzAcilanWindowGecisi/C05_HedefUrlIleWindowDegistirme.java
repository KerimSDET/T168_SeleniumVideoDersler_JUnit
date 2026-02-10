package tests.K12_SwitchingWindows.D02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v142.emulation.model.SensorType;
import utilities.TestBase_Each;

import java.util.Set;

public class C05_HedefUrlIleWindowDegistirme extends TestBase_Each {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a")).click();

        // acilan yeni window'a gecin
        // url ile gecis yapalim
        String hedefUrl = "https://elementalselenium.com/";

                /*
            acik olan tum window'larin whd'lerini kaydedelim
            bir for-each loop ile tum whd'lerini gozden gecirip
            her windowhandle degerinin sayfasina gecelim
            eger gectigimiz sayfada url hedefUrl'e esit ise
            loop'u bitirelim
         */

        // 1.adim acik tum window'larin whd'lerini alip kaydedelim

        Set<String> acikTumUrls = driver.getWindowHandles();
        for (String eachWhd:acikTumUrls){
            driver.switchTo().window(eachWhd);
            if (driver.getCurrentUrl().equals(hedefUrl)){
                // actual url, hedef url'e esit ise
                // dogru yerdeyiz demektir, orada kalalim
                break;
            }

        }

        // buyuk basligin "Elemental Selenium" oldugunu test edin

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi, actualYazi);
    }
}
