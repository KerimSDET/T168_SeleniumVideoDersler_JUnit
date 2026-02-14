package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_DosyaIndirmeTesti extends TestBase_Each {

    @Test
    public void DosyaIndirmeTesti() {

        // https://the-internet.herokuapp.com/download adresine git
        driver.get("https://the-internet.herokuapp.com/download");

        // webdriverIO.png dosyasini indir
        driver.findElement(By.xpath("//*[.='webdriverIO.png']")).click();

        //Dosyanin basariyla indirilip indirilmedigini test et

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/webdriverIO.png";

        ReuseableMethods.bekle(2);

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }



}
