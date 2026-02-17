package tests.K20_Screenshots;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C04_MethodlaScreenshot extends TestBase_Each {


    @Test
    public void C04_MethodlaScreenshots(){

        // Testotomasyonu anasayfaya gidelim
        driver.get("https://www.testotomasyonu.com");

        // Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();

        // Kullanici adi olarak wise@gmail.com girin
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys("wise@gmail.com");

        // password olarak 12345 girin
        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("12345");


        // sign in butonuna basarak sisteme giris yapin
        driver.findElement(By.id("submitlogin")).click();

        // giris yapilabildigini test etmek icin
        // Logout butonunun gorunur oldugunu test edin
        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButton.isDisplayed());

        ReuseableMethods.webElementResimCek(logoutButton);

        ReuseableMethods.webElementResimCek(logoutButton,"test");

        ReuseableMethods.tarihliWebElementResimCek(logoutButton);

        ReuseableMethods.tarihliWebElementResimCek(logoutButton,"test01");


        logoutButton.click();



    }
}
