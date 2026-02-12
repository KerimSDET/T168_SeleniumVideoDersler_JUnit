package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C02_Actions_DragAndDrop extends TestBase_Each {

    @Test
    public void DragAndDropTest(){
        //1 - https://testotomasyonu.com/droppable adresine gidilsin

        //2- Accept bolumunde "Acceptable" butonunu tutup "Drop Here" kutusunun ustune birak

        //3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin

        //4- Sayfayi yenileyin

        //5-"Not Acceptable" butonunu tutup "Drop Here" kutusuna bırak

        //"Drop Here" yazisinin degismedigini test edin

        //Senaryo:

        //1 - https://testotomasyonu.com/droppable adresine gidilsin
        driver.get("https://testotomasyonu.com/droppable");


        //2- Accept bolumunde "Acceptable" butonunu tutup "Drop Here" kutusunun ustune birak
        WebElement acceptableElementi = driver.findElement(By.id("draggable2"));
        WebElement dropHereKutuElementi = driver.findElement(By.id("droppable2"));

        System.out.println("Taşımadan once yazi : "+dropHereKutuElementi.getText());

        Actions actions = new Actions(driver);
        ReuseableMethods.bekle(1);

        actions.dragAndDrop(acceptableElementi, dropHereKutuElementi).perform();
        System.out.println("Taşıdıktan sonra yazı : "+dropHereKutuElementi.getText());


        //3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin

        String expectedDropped =  "Dropped!";
        String actualDropped = dropHereKutuElementi.getText();

        Assertions.assertEquals(expectedDropped, actualDropped);

        ReuseableMethods.bekle(1);

        //4- Sayfayi yenileyin

        driver.navigate().refresh();

        //5-"Not Acceptable" butonunu tutup "Drop Here" kutusuna bırak

        WebElement notAcceptableElementi = driver.findElement(By.id("draggable-nonvalid2"));
        dropHereKutuElementi = driver.findElement(By.id("droppable2"));
        actions.dragAndDrop(notAcceptableElementi, dropHereKutuElementi).perform();

        //"Drop Here" yazisinin degismedigini test edin

        String expectedDroppedUnAcc =  "Drop Here";
        String actualDroppedUnAcc = dropHereKutuElementi.getText();

        Assertions.assertEquals(expectedDroppedUnAcc, actualDroppedUnAcc);

        ReuseableMethods.bekle(2);

    }
}
