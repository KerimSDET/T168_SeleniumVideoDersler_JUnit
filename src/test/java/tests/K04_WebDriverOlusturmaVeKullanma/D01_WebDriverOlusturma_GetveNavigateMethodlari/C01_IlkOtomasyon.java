package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {
    public static void main(String[] args) throws InterruptedException {

        //bir test classı oluşturulduğunda ilk yapılamsı gerken şey
        //Web Driver edinmektir.


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com/");
        /*
        get methodu şstenilen URL'ye gider url yazarken www yazmazsak da WebDriver objesi url'e gider.
        ANCAK https: yazmazsak kod çalışmaz
         */

        Thread.sleep(3000);
        driver.close();

    }
}
