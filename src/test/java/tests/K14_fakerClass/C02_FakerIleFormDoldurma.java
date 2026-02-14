package tests.K14_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C02_FakerIleFormDoldurma extends TestBase_Each {

    @Test
    public void fakerIleFormDoldurma() {

        Faker faker = new Faker();

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

        WebElement firstName = driver.findElement(By.id("firstName"));

        String fakePassword = faker.internet().password();
        String fakeEmail = faker.internet().emailAddress();

        actions.click(firstName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
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
