package tests.K11_IFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C02_IFrame extends TestBase_Each {


    // 1- https://testotomasyonu.com/discount adresine gidin
    // 2- Elektronics Products yazisinin gorunur olduğunu test edin
    // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
    // 4- Sale Up To 50% yazisinin gorunur oldugunu test edin
    // 5- Fashion bolumundeki ilk urunu tiklayin
    //    ve ilk urun isminde "Men Slim Fit" gectigini test edin

    @Test
    public void test01(){
        // 1- https://testotomasyonu.com/discount adresine gidin
    driver.get("https://testotomasyonu.com/discount");

        // 2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement electonicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electonicsIframe);

        WebElement electonicsProductsYazisi = driver.findElement(By.xpath("//*[.='Electronics Products']"));
        Assertions.assertTrue(electonicsProductsYazisi.isDisplayed());

        // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[@id=\"pictext1\"]/span")).getText();

        Assertions.assertEquals(expectedUrunIsmi, actualUrunIsmi);

        WebElement baslikElementi = driver.findElement(By.tagName("h2"));
        System.out.println("Baslik elementi: " + baslikElementi.getText()); //h2 tagı ne verdigini gormek icin yazdik

        // 4- Sale Up To 50% yazisinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();

        String expectedSaleUp = "Sale Up To 50%";
        String actualSaleUp = driver.findElement(By.xpath("/html/body/div[2]/h2")).getText();

        Assertions.assertEquals(expectedSaleUp, actualSaleUp);

        WebElement baslikElementi2 = driver.findElement(By.tagName("h2"));
        System.out.println("Baslik elementi: " + baslikElementi2.getText()); //h2 tagı ne verdigini gormek icin yazdik

        // 5- Fashion bolumundeki ilk urunu tiklayin
        //gorev degistirdik tiklayinca yeni sayfada acinda bir sonraki ders konusuymus.
        //yeni gorev: ilk urun ismini locate edin

        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);
        driver.findElement(By.xpath("//*[@id=\"pictext1\"]/p")).getText();

        //    ve ilk urun isminde "Men Slim Fit" gectigini test edin
        String expectedFashionUrunIsmi = "Men Slim Fit";
        String actualFashionUrunIsmi =driver.findElement(By.xpath("//*[@id=\"pictext1\"]/p")).getText();

        Assertions.assertTrue(actualFashionUrunIsmi.contains(expectedFashionUrunIsmi));



    }

}
