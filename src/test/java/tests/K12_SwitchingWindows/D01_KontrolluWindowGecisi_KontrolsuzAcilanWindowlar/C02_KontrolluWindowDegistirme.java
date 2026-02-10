package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase_Each;

public class C02_KontrolluWindowDegistirme extends TestBase_Each {


    /*

            Eger bize verilen gorevde
            yeni bir Tab veya yeni bir Window acilmasi isteniyorsa
            driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.WINDOW);
            ile yeni bir Tab veya Window acip, driver'i yeni window'a otomatik olarak gecirebiliriz

            Eger testimiz sirasinda birden fazla window aciliyorsa
            driver'i istedigimiz window'a gecirmek icin
            hedef window'un WindowHandle degerini girmeliyiz
            driver.switchTo().window(wisequarterWhd);

            Eger birden fazla window aciyorsak ve geri donmemiz gerekecekse
            acilan her window'un window handle degerini kaydetmek
            faydali olacaktir.

         */

    @Test
    public void test01(){

        // testotomasyonu sayfasina gidin
        driver.get("https://testotomasyonu.com/");

        // whd'ini kaydedin ve yazdirin
        String testOtomasyonUrlWHD = driver.getWindowHandle();
        System.out.println("Test Otomasyon Window Handle Degeri : "+testOtomasyonUrlWHD);

        System.out.println("Acik olan tum window'larin whd'leri : "+ driver.getWindowHandles());


        // yeni bir tab acip, yeni tab'da wisequarter sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com/");

        // whd'ini kaydedin ve yazdirin
        String wiseUrlWHD = driver.getWindowHandle();
        System.out.println("Wisequarter Window Handle Degeri : "+wiseUrlWHD);

        System.out.println("Acik olan tum window'larin whd'leri : "+ driver.getWindowHandles());

        // yeni bir window acarak, arabam.com sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.arabam.com");

        // whd'ini kaydedin ve yazdirin
        String arabam_comUrlWHD = driver.getWindowHandle();
        System.out.println("Arabam.comn Window Handle Degeri : "+arabam_comUrlWHD);

        System.out.println("Acik olan tum window'larin whd'leri : "+ driver.getWindowHandles());

        // wisequarter'in acik oldugu window'a donun
        // ve url'in wisequarter icerdigini test edin
        driver.switchTo().window(wiseUrlWHD);
        String expectedWiseUrlIcerik = "wisequarter";
        String actualWiseUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualWiseUrl.contains(expectedWiseUrlIcerik));
        System.out.println("Acik olan tum window'larin whd'leri : "+ driver.getWindowHandles());


        // testotomasyonu'nun acik oldugu window'a donun
        driver.switchTo().window(testOtomasyonUrlWHD);

        // ve url'in testotomasyonu icerdigini test edin
        String expectedTOUrlIcerik = "testotomasyonu";
        String actualTOUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualTOUrl.contains(expectedTOUrlIcerik));

        System.out.println("Acik olan tum window'larin whd'leri : "+ driver.getWindowHandles());

    }
}
