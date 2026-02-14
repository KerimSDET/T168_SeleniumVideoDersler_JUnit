package tests.K17_Cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_Cookies extends TestBase_Each {


    @Test
    public void C01_Cookies() {



        // Google anasayfaya gidin
        driver.get("https://www.google.com");

        // cookies cikarsa kabul edin
        ReuseableMethods.bekle(1);

//        driver.findElement(By.xpath("//*[text()='Accept all']")).click();

        try {
            driver.findElement(By.xpath("//*[text()='Accept all']")).click();
            System.out.println("Cookie kabul edildi");
        } catch (Exception e) {
            System.out.println("Cookie popup çıkmadı, devam ediliyor.");
        }



        // sayfada kac adet cookies bulundugunu yazdirin
        Set<Cookie> sayfadakiCookieSet = driver.manage().getCookies();
        System.out.println("Sayfadaki cookie sayisi : " + sayfadakiCookieSet.size());


        // sayfadaki cookie'leri yazdirin
        System.out.println(sayfadakiCookieSet);


        // daha anlasilir olmasi icin bir for-each loop ile cookie'leri yazdiralim

        System.out.println("====================");
        int siraNo = 1;

        for (Cookie eachCookie : sayfadakiCookieSet) {
            System.out.println(siraNo + ". Cookie : " + eachCookie);
            siraNo++;
        }


        // cookie'lerin isimlerini yazdirin

        System.out.println("====================");
        siraNo = 1;

        for (Cookie eachCookie : sayfadakiCookieSet) {
            System.out.println(siraNo + ". Cookie : " + eachCookie.getName());
            siraNo++;
        }



        // ismi SOCS olan cookie'nin degerinin // ben de UULE isim var. SOCS yok
        // "CAISHAgBEhJnd3NfMjAyNDEyMTAtMF9SQzEaAmVuIAEaBgiAuPi6Bg" oldugunu test edin

//        String expectedValueCookie = "529=JZUsLGAOJHCYu1uymLFOYVYe7mefMFCMn1hT5_nK5YlubiV3jOTyArNsZ5r093PGvYlOUmuYPtK8-eRSkxlOwBSEWSSGNpSz6DCI4H5FkynO66G3ttIKsy7LMLNakmrNOlIiWWOcCoidddu12bcqEBX3TbZTtQcCcShRLai7JdKdC1hlOYmrH7FXQR1RjdBOYj_ZmviIFwiFtgdUC_WnlFApTxM0CkEhIgk4SmPg1aNd";
//        String actualValueCookie = driver.manage().getCookieNamed("NID").getValue();
//
//        Assertions.assertEquals(expectedValueCookie, actualValueCookie);


        // ismi enSevdigimCookie, degeri cikolataliCookie olan bir cookie olusturup
        // sayfaya ekleyin
        Cookie yeniCookie = new Cookie("enSevdigimCookie", "cikolataliCookie");
        driver.manage().addCookie(yeniCookie);

        // tum cookie'leri yazdiralim
        sayfadakiCookieSet = driver.manage().getCookies();
        System.out.println("===================");
        siraNo=1;
        for (Cookie eachCookie : sayfadakiCookieSet) {
            System.out.println(siraNo + ". Cookie : " + eachCookie);
            siraNo++;
        }

        // cookie'yi ekleyebildigimizi test edin

        Assertions.assertTrue(sayfadakiCookieSet.contains(yeniCookie));


        // ismi SOCS olan cookie'yi silin //UELE


        driver.manage().deleteCookieNamed("UULE");


        // ve silindigini test edin

        sayfadakiCookieSet = driver.manage().getCookies();
        System.out.println("===================");
        siraNo=1;
        for (Cookie eachCookie : sayfadakiCookieSet) {
            System.out.println(siraNo + ". Cookie : " + eachCookie);
            siraNo++;
        }



        /*
                tum cookie'lerin isimlerini kontrol ettik
                ismi SOCS olan varsa socsVarMi= true,
                ismi SOCS olan yoksa socsVarMi= false, olacak
         */




        // tum cookie'leri silin

        driver.manage().deleteAllCookies();



        // ve silindigini test edin

        sayfadakiCookieSet = driver.manage().getCookies();
        System.out.println("===================");
        siraNo=1;
        for (Cookie eachCookie : sayfadakiCookieSet) {
            System.out.println(siraNo + ". Cookie : " + eachCookie);
            siraNo++;
        }

        // sayfada kac adet cookies bulundugunu yazdirin
        Set<Cookie> sayfadakiCookieSet1 = driver.manage().getCookies();
        System.out.println("Sayfadaki cookie sayisi : " + sayfadakiCookieSet1.size());

        //ReuseableMethods.bekle(2);



    }
}
