package tests.K13_actionsClass.D02_keyboardBasedActions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C03_AsagiInme extends TestBase_Each {

    @Test
    public void AsagiInme() {
        //1-https://html.com/tags/iframe/ adesine git
        driver.get("https://html.com/tags/iframe/");

        // 2-videoyu gormek icin asagi in

        Actions actions = new Actions(driver);
        ReuseableMethods.bekle(1);

        //video bir iframe icindeymiş. once bunu locate edip gecis yapmali
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement videoIframe = driver.findElement(By.xpath("//iframe[contains(@src,'youtube')]"));
        driver.switchTo().frame(videoIframe);

//        WebElement videoLocate = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
//        actions.moveToElement(videoLocate).perform();

//        driver.findElement(By.xpath(" //button[@title='Play']"));
//        actions.moveToElement(videoPlayLocate).click().perform();

        //play tusuna bas video calissin

        driver.findElement(By.xpath("//button[@title='Oynat']")).click();


        ReuseableMethods.bekle(5);

    }
}
