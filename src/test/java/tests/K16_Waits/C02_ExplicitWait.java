package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReuseableMethods;

import java.time.Duration;

public class C02_ExplicitWait {

    WebDriver driver;
    @Test
    public void C01_implicitlyWait(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        ReuseableMethods.bekle(3);
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin
            //                                                                          //*[.="It's gone!"]
        WebElement itsGoneText = driver.findElement(By.xpath("//*[@id='message']"));
        Assertions.assertTrue(itsGoneText.isDisplayed());

        //4. Add buttonuna basin

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

//        driver.findElement(By.xpath("//*[.='Add']")).click();
        ReuseableMethods.bekle(3);

        //5. It’s back mesajinin gorundugunu test edin

        WebElement ItsBackIsDisplayed = driver.findElement(By.xpath("//*[@id='message']"));
        Assertions.assertTrue(ItsBackIsDisplayed.isDisplayed());


        driver.quit();

    }

    @Test
    public void C01_ExplicitlyWait(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin
        //                                                                          //*[.="It's gone!"]
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement itsGoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));

        //4. Add buttonuna basin

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

//        driver.findElement(By.xpath("//*[.='Add']")).click();

        //5. It’s back mesajinin gorundugunu test edin

        WebElement ItsBackIsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));


        driver.quit();

    }
}
