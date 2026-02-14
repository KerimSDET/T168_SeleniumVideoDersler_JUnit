package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C03_OlmayanElementiTestEtme extends TestBase_Each {

    @Test
    public void C03_OlmayanElementiTestEtme() {

        /*
            Olmayan veya gorunmeyen bir WebElementi test etmek icin
            olusacak exception'i belirleyip
            exception olusmasini TESTIN PASSED olmasi icin bir basamak yapmaliyiz

            exception olusmamasi durumunda ise TEST FAILED olmalidir
         */

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // it's gone yazisi gorununceye kadar bekleyin
        ReuseableMethods.bekle(3);

        //3. checkbox'in gorunur olmadigini!! test edin


        try {
            WebElement checkBox = driver.findElement(By.xpath("//*[@id='checkbox']"));
            //locate edilirse checkbox gorunur demektir.
            //bu gorevin failed olmasidir
            Assertions.assertTrue(false,"Check box gorunur, Test Failed");
        } catch (NoSuchElementException e) {
            //bu aşamada checkbox locate edemedigi icin hata verecektir.
            //bu durumda ise olmayan eleman test edilebilir.
            Assertions.assertTrue(true,"Test PASSED"); //Gorev passed olur
        }



        // locate edebildiyse, checkbox gorunuyor demektir
        // bu da bizden istenen gorevin failed olmasi anlamina gelir
        // Checkbox'i locate edemedigi icin NoSuchElementException olusur
        // bu aslinda bizden istenen gorevin
        // yani checkBox'in gorunemediginin ispatidir


        //4. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. checkbox'in gorunur oldugunu test edin

        WebElement checkBoxControl = driver.findElement(By.xpath("//*[@id='checkbox']"));
        checkBoxControl.isDisplayed();

        //ReuseableMethods.bekle(3);


    }
}
