package tests.K05_WebElements_Locators.D03_byTageName_byLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WebElementMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://www.testotomasyonu.com/form adresine gidin
        driver.get("https://www.testotomasyonu.com/form");

        //cinsiyet bolumunden size uygun radio button secin

        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        erkekRadioButton.click();

        //istediğiniz radio button'un secili oldugunu test edin.

        if (erkekRadioButton.isSelected()) {
            System.out.println("Seçtiğimiz Radio Button Testi PASSED");
        } else System.out.println("Seçtimiz Radio Button Testi FAILED");

        //kadin radio butonu secili olmadigini test edin.

        if (!kadinRadioButton.isSelected()) {
            System.out.println("Seçmediğimiz Radio Button1 Testi PASSED");
        } else System.out.println("Seçmediğimiz Radio Button1 Testi FAILED");

        if (!digerRadioButton.isSelected()) {
            System.out.println("Seçmediğimiz Radio Button3 Testi PASSED");
        } else System.out.println("Seçmediğimiz Radio Button3 Testi FAILED");

        //soyisim kutusunun boyutlarini ve konumunu yazdirin

        WebElement soyIsimKutusu = driver.findElement(By.id("surname"));

        System.out.println("Soyisim Kutusu Boyutu : "+soyIsimKutusu.getSize());
        System.out.println("Soyisim Kutusu Konum : "+soyIsimKutusu.getLocation());

        //soyisim kutusunun HTML kodundaki class attribute degerinin
        // "form-control" oldugunu test edin.

        String expectedAtrDegeri = "form-control";
        String actualAtrDegeri = soyIsimKutusu.getAttribute("class");


        if (expectedAtrDegeri.equals(actualAtrDegeri)) {
            System.out.println("Soyisim Kutusu Class Attribute tesi PASSED");
        } else System.out.println("Soyisim Kutusu Class Attribute tesi FAILED");

        Thread.sleep(2000);

        driver.quit();





    }

}
