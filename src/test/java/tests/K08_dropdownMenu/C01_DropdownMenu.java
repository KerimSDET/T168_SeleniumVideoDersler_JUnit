package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReuseableMethods;
import utilities.TestBase_All;

import java.util.List;

public class C01_DropdownMenu extends TestBase_All {

    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunun 4 olduğunu test edin

    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    @Test
    public void C01_DropdownMenu() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1- dropdown menuyu locate edip kaydet
        WebElement ddmLocate = driver.findElement(By.id("dropdown"));

        //2- Select classtan obje olustur ve parametre olarak ddmLocate gir
        Select dropdown = new Select(ddmLocate);

        //3-  olusuturulan bu obje ile istenilen isi yap

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        dropdown.selectByIndex(1);

        System.out.println(dropdown.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        dropdown.selectByValue("2");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        dropdown.selectByVisibleText("Option 1");

        System.out.println(dropdown.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın
            //a - tum listeyi text olarak yazdir
        System.out.println(ddmLocate.getText());

        //b - tum listeyi text olarak yazdir
        List<WebElement> tupmOptionElementlerList = dropdown.getOptions();




        //5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedDropDownBoyutu = 3; //4 tü
        int actualDropDownBoyutu = tupmOptionElementlerList.size();
        Assertions.assertEquals(expectedDropDownBoyutu, actualDropDownBoyutu);




    }







}
