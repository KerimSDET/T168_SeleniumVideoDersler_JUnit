package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){


        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        String expectedText = "Opening a new window";
        String actualText = sayfadakiText.getText();

        Assertions.assertEquals(expectedText,actualText);



        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        String ilkWindowWDH = driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

        System.out.println("ilk acilan window handle degeri : "+ilkWindowWDH);
        System.out.println("click sonrası driver'in oldugu window handle degeri : "+driver.getWindowHandle());

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("window handles: "+windowHandles);

        ReuseableMethods.bekle(3);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin

        /*
            driver.getWindowHandle();
            method'u icerisinde oldugu window'un window handle degerini bize getirir
            ve biz de kaydedebiliriz

            bir window'un whd'ini kaydettikten sonra
            nerede olursak olalim
            driver.switchTo().window(hedefWindowunWHDi); ile bu window'a gecis yapabiliriz

            Kontrolsuz window acildiginda
            driver beklemedigi bir durum oldugundan
            yeni window'a gecmez, eski window'da kalir

            yeni window'a gecemedigimiz icin
            yeni window'un whd'ini de alamayiz
         */

    /*
            Yeni window'un whd'ini bulmak icin mini bir bulmaca cozmeliyiz
            Baslangicta alip kaydettigimiz
            ilk window whd'ini biliyoruz

            Acik olan tum window'larin whd'lerini
            getWindowHandles() ile alip bir Set'e kaydedebiliriz.

            Set'i bir for-each loop ile gozden gecirip
            ilk window'un whd'ne esit olmayan elemani
            ikinci window'un whd'i olarak atayabiliriz
         */
        String ikinciWindowWDH = driver.getWindowHandle();
        for (String eachWHD: windowHandles){
           if (! eachWHD.equals(ilkWindowWDH)){
               ikinciWindowWDH = eachWHD;
           }
        }

    /*
            ilk window'un whd'ini en basta kaydetmistik
            simdi ikinci window'un whd'ine de sahibiz

            artik switchTo() ile istedigimiz window'a gecis yapabiliriz

         */
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin

        /*
            yeni window kontrolsuz olarak acildigi icin
            driver hala eski window'da
            yeni window ile ilgili islem yapmadan once
            driver'i yeni window'a gecirmeliyiz
         */
        driver.switchTo().window(ikinciWindowWDH);
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expectedText = "New Window";
        actualText = driver.findElement(By.xpath("/html/body/div/h3")).getText();
        Assertions.assertEquals(expectedText,actualText);


                //● Bir önceki pencereye geri dönun

        driver.switchTo().window(ilkWindowWDH);

        //  ve sayfa başlığının “The Internet” olduğunu test edin

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);



    }


}
