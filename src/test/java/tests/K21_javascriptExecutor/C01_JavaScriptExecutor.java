package tests.K21_javascriptExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C01_JavaScriptExecutor extends TestBase_Each {

    @Test
    public void C01_JavaScriptExecutor() {


        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");


        // isitme kaybi checkbox gorunecek kadar asagi inin

        // 1.adim jse objesi olustur
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // 2.adim kullanmak istedigimiz Webelementi locate edip kaydedin
        WebElement isitmeKaybiCheckBox = driver.findElement(By.id("hastalikCheck5"));


        //3.adim jse.executeScript() ile istenen islemi yapin
        // isitme kaybi checkbox gorunecek kadar asagi inin
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'})",isitmeKaybiCheckBox);

        ReuseableMethods.bekle(2);
        // jse kullanarak isitme kaybi checkbox'i isaretleyin

        jse.executeScript("arguments[0].click()",isitmeKaybiCheckBox);
        ReuseableMethods.bekle(2);

        // javascript Alert kullanarak "JUnit BITTTIIIII" yazdirin
        jse.executeScript("alert('JUnit BITTTIIIII!')");
        ReuseableMethods.bekle(2);


    }
}
