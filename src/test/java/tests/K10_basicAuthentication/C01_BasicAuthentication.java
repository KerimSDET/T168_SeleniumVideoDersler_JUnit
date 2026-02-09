package tests.K10_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class C01_BasicAuthentication extends TestBase_Each {


    @Test
    public void test01(){


//1- Bir class olusturun : BasicAuthentication
//2- https://testotomasyonu.com/basicauth sayfasina gidin
        driver.get("https://testotomasyonu.com/basicauth/");


//3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

//Html komutu : https://username:password@URL
//	Username     : membername
// 	password      : sunflower


        //4 basarli sekilde girildigini test edin

        String expectedYazi ="Basic Auth";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi, actualYazi);



    }


        /*
        driver.get("https://testotomasyonu.com/basicauth");
         sadece url'e gidersek UI ile kullanici adi ve sifre girmemiz gerekir
         ancak otomasyon ile gittigimizde
         kullanici adi ve sifresi bolumunu locate edemedigimizden kullanamayiz
         bunun yerine kullandigimiz url'in sahibi olan sirketin
         bize verecegi kullanici adi ve sifresini
         yine sirketin bize tarif edecegi yontemle URL'e eklemeliyiz
         */

    //4- Basarili sekilde sayfaya girildigini dogrulayin




}
