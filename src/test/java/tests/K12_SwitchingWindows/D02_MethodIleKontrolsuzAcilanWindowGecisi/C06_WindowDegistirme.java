package tests.K12_SwitchingWindows.D02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C06_WindowDegistirme extends TestBase_Each {

    @Test
    public void test01_WindowDegistirme(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a")).click();

        // acilan yeni window'da buyuk basligin "Elemental Selenium" oldugunu test edin
        // once title kullanarak yeni window'a gecelim
        ReuseableMethods.titleIleWindowGecisYap(driver,"//*[@id=\"__docusaurus_skipToContent_fallback\"]/header/div/h1");

        String expectedText = "Elemental Selenium";
        String actualText = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedText, actualText);
        //ReuseableMethods.bekle(2);

        // ilk window'a geri donun
        ReuseableMethods.urlIleWindowGecisYap(driver,"https://the-internet.herokuapp.com/windows");

        // "Opening a new window" yazisinin gorunur oldugunu test edin
        String expectedText1 = "Opening a new window";
        String actualText1 = driver.findElement(By.xpath("//*[@id=\'content\']/div/h3")).getText();

        Assertions.assertEquals(expectedText1, actualText1);
        //ReuseableMethods.bekle(4);

        // Click here'a basin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        // Acilan yeni window'a gecip,
        ReuseableMethods.titleIleWindowGecisYap(driver,"New Window");


        // oradaki yazinin "New Window" oldugunu test edin
        expectedText = "New Window";
        actualText = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedText, actualText);


        // Elemental selenium'un acik oldugu window'a gecip
        ReuseableMethods.urlIleWindowGecisYap(driver,"https://elementalselenium.com/");


        // Tips linkinin erisilebilir oldugunu test edin
        WebElement tipsElement = driver.findElement(By.xpath("//*[@id='__docusaurus']/nav/div[1]/div[2]/a[1]"));
        Assertions.assertTrue(tipsElement.isEnabled());


    }
}
