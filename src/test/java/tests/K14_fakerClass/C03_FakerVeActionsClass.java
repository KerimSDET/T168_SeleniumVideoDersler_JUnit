package tests.K14_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C03_FakerVeActionsClass extends TestBase_Each {

    @Test
    public void c03_FakerVeActionsClass() {

        Faker faker = new Faker();

        //https:www.facebook.com adresine gir

        driver.get("https:www.facebook.com");

        //cookies kabul et

//        if (driver.findElement(By.xpath("(//span[.='Allow all cookies'])[3]")).isDisplayed()){
//            driver.findElement(By.xpath("(//span[.='Allow all cookies'])[3]")).click();
//        }

        driver.findElement(
                By.xpath("//a[@data-testid='open-registration-form-button']")
        ).click();


        //yeni hesap olustura bas

        //ad soyad mail ve sifre kutularıina degerlesi yaz
        //tarih ve cinsiyet secimleri yap ve kaydola bas

        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions = new Actions(driver);
        ReuseableMethods.bekle(1);

        actions.click(firstname)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("01")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1986")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();

        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

        ReuseableMethods.bekle(5);
    }
}
