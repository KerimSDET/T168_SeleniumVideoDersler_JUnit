package tests.K05_WebElements_Locators.D04_byXpath_cddLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath_TextKullanimi {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // https://tstotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //add element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //remove butonunun gorunur oldugunu test edin

        WebElement removeButonu = driver.findElement(By.xpath("//*[text()='Remove']"));

        if (removeButonu.isDisplayed()){
            System.out.println("Remove button testi PASSED");
        }else System.out.println("Remove button testi FAILED");

        //remove butonunua basınız
        removeButonu.click();

        // "Add/Remove Elements" yazisinin gorunur oldugunu test edin

        //WebElement addRemoveYaziElementi = driver.findElement(By.tagName("h2")); //tagname hali

        WebElement addRemoveYaziElementiXPath = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")); //xpath haline getirilmis

        if (addRemoveYaziElementiXPath.isDisplayed()){
            System.out.println("Add remove button yazi testi PASSED");
        } else System.out.println("Add remove button yazi testi FAILED");

        // sayfayi kapatin
        driver.quit();



    }
}
