package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C04_FileUploadTesti extends TestBase_Each {

    @Test
    public void DosyaUploadTesti() {

        //https://the-internet.herokuapp.com/upload adresine git
        driver.get("https://the-internet.herokuapp.com/upload");

        //choose file butonuna bas
        WebElement chooseFileButon = driver.findElement(By.id("file-upload"));

        //proje altindaki yeni klasör/eula.txt dosyasini sec
        String dinamikDosyaYoluSec = System.getProperty("user.dir") +"/src/test/java/tests/week03_fileTestleri/eula.txt" ;

        chooseFileButon.sendKeys(dinamikDosyaYoluSec);

        //upload butonuna bas

        driver.findElement(By.id("file-submit")).submit();

        //File uploaded! textinin goruntulendigibi test et

        WebElement fileUploadResult = driver.findElement(By.xpath("//*[@id=\'content\']/div/h3"));

        String expectedResult = "File Uploaded!";
        String actualResult = fileUploadResult.getText();

        Assertions.assertEquals(expectedResult, actualResult);

        ReuseableMethods.bekle(3);


    }

}
