package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C03_Actions_MoveToElement extends TestBase_Each {

    @Test
    public void moveToElement() {

        //1- https://www..testotomasyonu.com/ adresine git
        driver.get("https://www.testotomasyonu.com/");

        //"Kids Wear" menusunun acilmasi icin mouse ile bu menu ustune git
        WebElement kidsWearElementi = driver.findElement(By.xpath("//*[@id=\'header_sticky\']/header/div[4]/div/div/div[1]/div/div/nav/ul/li[8]/a"));

        Actions actions = new Actions(driver);

        actions.moveToElement(kidsWearElementi).perform();


        //"Boys" linkine bas
        driver.findElement(By.xpath("//*[@id=\'header_sticky\']/header/div[4]/div/div/div[1]/div/div/nav/ul/li[8]/div/div/div/div/ul/li[1]/a")).click();

        //Acilan sayfadaki ilk urunu tikla
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        //Acilan sayfada urun isminin "Boys Shirt White Color" oldugunu test et.

        WebElement isimElement = driver.findElement(By.xpath("//*[@id=\'shop-listing\']/div/div[1]/div[2]/div[1]"));

        String ecpectedIsim = "Boys Shirt White Color";
        String actualIsim = isimElement.getText();

        Assertions.assertEquals(actualIsim, ecpectedIsim);

        ReuseableMethods.bekle(5);


    }
}
