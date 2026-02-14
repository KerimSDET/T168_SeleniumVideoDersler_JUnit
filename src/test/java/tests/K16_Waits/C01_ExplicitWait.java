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
import utilities.TestBase_Each;

import java.time.Duration;

public class C01_ExplicitWait {

    WebDriver driver;

    @Test
    public void C01_implicitlyWait (){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
        //Iki metod icin de asagidaki adimlari test edin.
        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();

        ReuseableMethods.bekle(3);


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue(textBox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        //WebElement itsEnabledText =
                driver.findElement(By.xpath("//*[@id=\"message\"]")).isDisplayed();



        driver.quit();

    }

    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

    @Test
    public void C01_ExplicitlyWait (){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
        //Iki metod icin de asagidaki adimlari test edin.
        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tıklayın ve

        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();

        //textbox etkin oluncaya kadar bekleyin

        /*
            implicitlyWait() iki durumda bekleme yapar
            1- sayfanin yuklenmesi
            2- bir webelement'in locate edilmesi icin

            gorevin 4.maddesinde textbox'in etkin olmasini beklememiz gerekiyor
            ancak bu bekleme implicitlyWait()'in gorev kapsaminda yok
            bu sebeple implicitlyWait() ile yaptigimizda
            4.gorev FAILED olacaktir

            Testin passed olmasi icin mutlaka ekstra bekleme gerekir
            4.gorevin gerceklesmesi icin Thread.sleep() kullandik
         */

        // 1.adim bir wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 2.adim MUMKUNSE beklenecek objeyi locate edip bir webelement olarak kaydedin
        //        textbox'i locate edebiliyoruz ve yukarda locate edip kaydettik

        // 3.adim wait objesine neyi bekleyecegini soyleyin
        wait.until(ExpectedConditions.elementToBeClickable(textBox));


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue(textBox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledText = driver.findElement(By.xpath("//*[@id=\"message\"]"));

        Assertions.assertTrue(itsEnabledText.isDisplayed());


        ReuseableMethods.bekle(3);

        driver.quit();

    }
}
