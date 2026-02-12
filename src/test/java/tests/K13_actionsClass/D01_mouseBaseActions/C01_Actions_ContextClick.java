package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C01_Actions_ContextClick extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/click sitesine gidelim
        driver.get("https://testotomasyonu.com/click");

        // "DGI Drones" uzerinde sag click yapalim
        WebElement DGIDronesElementi = driver.findElement(By.xpath("//*[@id='hot-spot']"));

        Actions  actions = new Actions(driver);
        ReuseableMethods.bekle(1); //fonksiyonun yüklenmesi için beklemek gerekir

        actions.contextClick(DGIDronesElementi).perform();

        // Alert'te cikan yazinin "Tebrikler!... Sağ click yaptınız." oldugunu test edelim
        String expectedYazi ="Tebrikler!... Sağ click yaptınız.";
        String actualYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedYazi, actualYazi);


        // Tamam diyerek alert'i kapatalim.

        driver.switchTo().alert().accept();


    }
}
