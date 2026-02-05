package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase_All;

import java.time.Duration;

public class C03_DropdownMenu2 extends TestBase_All {

    @Test
    public void dropdownMenu() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        // 3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");

        // 4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");

        // 5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();

// ⚠️ LOGIN BAŞARILI OLMAYACAK → BEKLEME YOK
        driver.navigate().back();

// Ana sayfaya döndüğümüzü garanti et
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//strong[text()='Online Banking']")));

// 6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();


        // 7. “Purchase Foreign Currency” tusuna basin

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Foreign Currency')]")
        )).click();


        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropdown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropdown);
        select.selectByValue("EUR");

        // 9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("500");

        // 10. “US Dollars” in secilmedigini test edin
        WebElement usdRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assertions.assertFalse(usdRadioButton.isSelected());

        // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        // 13. Sonuc mesajini kontrol edin
        String expectedMessage = "Foreign currency cash was successfully purchased.";
        String actualMessage = driver.findElement(By.id("alert_content")).getText();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
