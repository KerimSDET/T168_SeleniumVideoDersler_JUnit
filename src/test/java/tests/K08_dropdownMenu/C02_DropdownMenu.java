package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;

public class C02_DropdownMenu extends TestBase_Each {

    //● https://testotomasyonu.com/form adresine gidin.
    //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //4. Secilen değerleri konsolda yazdirin
    //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
    //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

    @Test
    public void C03_DropdownMenu_01() {
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

        //once locate etmeliyiz
        WebElement ddmGun = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        //sonra bir select objesi olusturun ve parametre olarak ddm yu girelim
        Select selectGunDdm = new Select(ddmGun);

        //olusturulan selenctGunDdm objesi sayesinde select hazir methodlariyla istenilen islemleri yap
        selectGunDdm.selectByIndex(2);



        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ddmAy = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAyDdm = new Select(ddmAy);
        selectAyDdm.selectByIndex(11);

        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement ddmYil = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYilDdm = new Select(ddmYil);
        selectYilDdm.selectByVisibleText("1983");
        ReuseableMethods.bekle(2);


        //4. Secilen değerleri konsolda yazdirin

        System.out.println(selectGunDdm.getFirstSelectedOption().getText());
        System.out.println(selectAyDdm.getFirstSelectedOption().getText());
        System.out.println(selectYilDdm.getFirstSelectedOption().getText());

        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        System.out.println(ddmAy.getText());

        //menudeki aylardan "Ocak" degerinin bulundugunu test edin
        Assertions.assertTrue(ddmAy.getText().contains("Ocak"));

        // alternatif yol
        List<String> ddmAyListesi = new ArrayList<>();
        List<WebElement> ddmAyElementleriList = selectAyDdm.getOptions();

        for (WebElement eachAy: ddmAyElementleriList){

            ddmAyListesi.add(eachAy.getText());

        }
        System.out.println(ddmAyListesi);

        Assertions.assertTrue(ddmAyListesi.contains("Ocak"));

        //3. yontem ReusableMethods methodla yapma

        Assertions.assertTrue(ReuseableMethods.stringListeDondur(ddmAyElementleriList).contains("Ocak"));

        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedAyDdmBoyut = 13;
        int actualAyDdmBoyut = selectAyDdm.getOptions().size();

        Assertions.assertEquals(expectedAyDdmBoyut, actualAyDdmBoyut);



    }


}
