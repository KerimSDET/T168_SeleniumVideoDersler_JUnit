package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Each;

public class C04_Actions extends TestBase_Each {
    @Test
    public void C04_Actions(){

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin

        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverElementi = driver.findElement(By.xpath("//*[@id=\'div-hover\']/div[1]/button"));

        Actions actions = new Actions(driver);

        actions.moveToElement(hoverOverElementi).perform();

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("//*[@id=\'div-hover\']/div[1]/div/a")).click();
        

        //4- Popup mesajini yazdirin
        System.out.println("Alert Uyarısı : "+ driver.switchTo().alert().getText());


        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldElementi = driver.findElement(By.id("click-box"));

        actions.clickAndHold(clickAndHoldElementi).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Basılı iken yazi : " +clickAndHoldElementi.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickElementi = driver.findElement(By.id("double-click"));

        System.out.println("Double click yapmadan once class attr : "+ doubleClickElementi.getAttribute("class"));

        actions.doubleClick(doubleClickElementi).perform();

        //System.out.println("cift click yapilmadan class attribute : " + doubleClickElementi.getAttribute("class"));
        //div-double-click

        System.out.println("Double click yaptiktan once class attr : "+ doubleClickElementi.getAttribute("class"));

        // cift tiklandigini test edin
        //System.out.println("cift click yapildiktan sonra class attribute : " + doubleClickElementi.getAttribute("class"));
        //div-double-click double
        String expectedDoubleClick = "div-double-click double";
        String actualDoubleClick = doubleClickElementi.getAttribute("class");

        Assertions.assertEquals(expectedDoubleClick, actualDoubleClick);

        System.out.println("Bu yazıyı okuyorsan testler PASSED");



    }
}
