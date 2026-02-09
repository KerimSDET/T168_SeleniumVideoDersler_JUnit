package tests.K05_WebElements_Locators.D05_relativesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://testotomasyonu.com/relativeLocators adresine git
        driver.get("https://testotomasyonu.com/relativeLocators/");

        //DSLR Camera'yi etrafindaki elementleri kullanarak
        // 3 farkli relative locator ile locate edip tiklayin.

        WebElement motorTelElementi = driver.findElement(By.id("pic8_thumb"));

        WebElement dslrCamera1 = driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelElementi));

        dslrCamera1.click();

        //Acilan urunun DSLR Camera oldugunu test edin.

        WebElement dslrCameraIsimElementi  = driver.findElement(By.xpath("//div [@class=' heading-sm mb-4']"));
        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)) {
            System.out.println("DSLR Camera testi1 PASSED");
        } else {
            System.out.println("DSLR Camera testi1 FAILED");
        }

            //https://testotomasyonu.com/relativeLocators adresine git
            driver.get("https://testotomasyonu.com/relativeLocators/");

        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));

        WebElement dslrCamera2 = driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toRightOf(appleKulaklik));

        dslrCamera2.click();

        dslrCameraIsimElementi  = driver.findElement(By.xpath("//div [@class=' heading-sm mb-4']")); //locte yeniden tanımladık
        expectedUrunIsmi = "DSLR Camera";
        actualUrunIsmi =  dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)) {
            System.out.println("DSLR Camera testi2 PASSED");
        } else System.out.println("DSLR Camera testi2 FAILED");

        //https://testotomasyonu.com/relativeLocators adresine git
        driver.get("https://testotomasyonu.com/relativeLocators/");

        WebElement batKulaklikElementi = driver.findElement(By.id("pic2_thumb"));

        WebElement dslrCamera3 = driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).below(batKulaklikElementi));

        dslrCamera3.click();

        dslrCameraIsimElementi  = driver.findElement(By.xpath("//div [@class=' heading-sm mb-4']"));
        expectedUrunIsmi = "DSLR Camera";
        actualUrunIsmi =  dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)) {
            System.out.println("DSLR Camera testi3 PASSED");
        } else System.out.println("DSLR Camera testi3 FAILED");


        driver.quit();

    }
}
