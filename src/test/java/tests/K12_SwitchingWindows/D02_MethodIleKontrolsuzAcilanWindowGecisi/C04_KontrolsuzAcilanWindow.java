package tests.K12_SwitchingWindows.D02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.Set;

public class C04_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void testCase01() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        String ilkWHD = driver.getWindowHandle();
        System.out.println("Acik olan ilk WHD : "+ilkWHD);

        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a")).click();


        // acilan yeni window'a gecip
        // gecisi yeni window'un title'ini kullanarak yapin
        Set<String> AllOpenWHD = driver.getWindowHandles();
        System.out.println("Acik olan Tum WHD : "+AllOpenWHD);

        String hedefWindowTitle = "Home | Elemental Selenium"; //driver.getTitle();

        for (String eachWhd:AllOpenWHD){
            driver.switchTo().window(eachWhd);
            //gectiigimiz window'un titl'ini alip gecmek istedigimiz
            // windowun title'ina esit mi kontrol edelim..
            if (driver.getTitle().equals(hedefWindowTitle)){
                //dogru windowdayiz demektir, burada kalmaliyiz
                break;
            }

        }

        // 1- acik olan tum window'larin WHD'lerini alip kaydedelim

        //   [E7DF36DB6F21C9F3FACD1171BE7A52E1, 0FD94DE1BF431FA11ECEFA6FF529A3CE]

        // gectigimiz window'un title'ini alip
        // gecmek istedigimiz window'un title'ina esit mi diye kontrol edelim


        // buyuk basligin "Elemental Selenium" oldugunu test edin
        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi, actualYazi);




    }
}
