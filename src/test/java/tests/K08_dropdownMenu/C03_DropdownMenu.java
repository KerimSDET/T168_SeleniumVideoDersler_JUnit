package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_All;

public class C03_DropdownMenu extends TestBase_All {

    //1. http://zero.webappsecurity.com/ Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password” yazin
    //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
    //6. Online banking menusunden Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

    @Test
    public void dropdownMenu(){

        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //3. Login kutusuna “username” yazin
        WebElement loginKutusu = driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username");

        //4. Password kutusuna “password” yazin
        //WebElement password =  driver.findElement(By.id("user_password"));
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.name("submit")).click();

        //sonra back tusuna basarak sayfaya donun
        driver.navigate().back();

        //6. Online banking menusunden Pay Bills sayfasina gidin

        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();

        driver.findElement(By.id("pay_bills_link")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDdm = driver.findElement(By.id("pc_currency"));
        Select selectCurrency = new Select(currencyDdm);
        selectCurrency.selectByValue("EUR");

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount']")).sendKeys("500");

        //10. “US Dollars” in secilmedigini test edin
        WebElement usDolarsRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assertions.assertFalse(usDolarsRadioButton.isSelected());


        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();


        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs']")).click();

        driver.findElement(By.id("purchase_cash")).click();


        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String expectedSonucEkran = "Foreign currency cash was successfully purchased.";
        String actualSonucEkran = driver.findElement(By.id("alert_content")).getText();

        Assertions.assertEquals(expectedSonucEkran, actualSonucEkran);


    }




}
