package tests.K13_actionsClass.D02_keyboardBasedActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C02_FormDoldurma extends TestBase_Each {

    @Test
    public void D02_FormDoldurma() {

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
//        driver.findElement(By.className("e-cart")).click();
        driver.findElement(By.linkText("Account")).click();





        //3- Sign Up linkine basalim
        //driver.findElement(By.cssSelector("a[href='https://www.testotomasyonu.com/customer-register']")).click();
        driver.findElement(By.xpath("//*[.=' Sign Up']")).click();


        //4- Ad, soyad, mail ve sifre kutularina deger yazalim


        Actions actions = new Actions(driver);

        ReuseableMethods.bekle(1);

        WebElement firstName =driver.findElement(By.id("firstName"));

        actions.click(firstName)
                .sendKeys("Abuzittin")
                        .sendKeys(Keys.TAB)
                                .sendKeys("Calabus")
                                        .sendKeys(Keys.TAB)
                                                .sendKeys("acalabus@gmail.com")
                                                        .sendKeys(Keys.TAB)
                                                                .sendKeys("aC987654.")
                                                                        .sendKeys(Keys.TAB)
                                                                                .sendKeys("aC987654.")
//                                                                                        .sendKeys(Keys.ENTER)
                .perform();




        /*
            Formdaki tum kutulari tek tek locate etmek yerine
            firstName kutusuna click yapip, isim gonderelim
            sonraki kutulara gecisi de TAB tusu ile yapabiliriz
         */



        //   ve Sign Up butonuna basalim
        driver.findElement(By.id("btn-submit-form")).click();

        ReuseableMethods.bekle(1);

        driver.findElement(By.linkText("Account")).click(); //register edilidigi icin profile bakalım

        //5- Kaydin olusturuldugunu test edin

        WebElement logOutCheck = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logOutCheck.isEnabled());

        /*
            Kayit yapinca bizi otomatik olarak giris sayfasina yonlendiriyor
            kaydin olustugunu test edebilmek icin
            giris yapalim
         */


        ReuseableMethods.bekle(1);

    }
}
