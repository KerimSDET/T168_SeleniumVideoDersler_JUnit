package tests.K18_WebTables.D01_KlasikHtmlTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_KlasikHtmlTablo extends TestBase_Each {

    @Test
    public void test01() {

        //1. "https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2. Web table tum body’sini yazdirin

        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
        System.out.println("tumBodyElementi : \n" + tumBodyElementi.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTabloIcerik = "Comfortable Gaming Chair";
        String actualTabloIcerik = tumBodyElementi.getText();

        Assertions.assertTrue(actualTabloIcerik.contains(expectedTabloIcerik));


        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> tumSatirElementiListi = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = tumSatirElementiListi.size();

        Assertions.assertEquals(expectedSatirSayisi, actualSatirSayisi);


        //5. Tum satirlari yazdirin


        System.out.println("========= Tüm Satırlar =========");
        System.out.println(ReuseableMethods.stringListeDondur(tumSatirElementiListi));

// eger satirlari belirterek yazdirmak isterseniz
        // bir for-each loop ile satirlari yazdirabilirsiniz

        int satirNo =1;

        for (WebElement eachSatirElementi : tumSatirElementiListi) {

            System.out.println("satirNo : " + satirNo+eachSatirElementi.getText());
            satirNo++;

        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        /*
           Web tablolarinda sutun olarak gruplama yoktur
           body / satirlar / datalar vardir
           eger sutun sayisini bulmak isterseniz
           her hangi bir satirdaki data sayisina bakabiliriz
           ornegin 1.satirdaki datalara bakalim
         */

        List<WebElement> birinciSatirElementLlisti = driver.findElements(By.xpath("//tr[1]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = birinciSatirElementLlisti.size();

        Assertions.assertEquals(expectedSutunSayisi, actualSutunSayisi);


        //7. 3.sutunu yazdirin
        /*
           Web tablolarinda sutun olarak gruplama yoktur
           3.sutun diyemedigimiz icin
           her satirdaki 3.datayi alip sutunu olustururuz
         */

        List<WebElement> ucuncuSutunEleementLlisti = driver.findElements(By.xpath("//tr[*]/td[3]"));

        System.out.println("Ucuncu Sutun Elementleri : " + ReuseableMethods.stringListeDondur(ucuncuSutunEleementLlisti));


        //8. Tablodaki basliklari yazdirin

        List<WebElement> baslikElementleriListi = driver.findElements(By.xpath("//thead//th"));

        System.out.println(ReuseableMethods.stringListeDondur(baslikElementleriListi));

        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("\n===================");
        System.out.println("1. satır, 2. sütun : " + getSatirSutunParametre(1,2));
        System.out.println("3. satır, 4. sütun : " + getSatirSutunParametre(3,4));
        System.out.println("5. satır, 1. sütun : " + getSatirSutunParametre(5,1));
        System.out.println("2. satır, 3. sütun : " + getSatirSutunParametre(2,3));
        System.out.println("4. satır, 2. sütun : " + getSatirSutunParametre(4,2));


        //Medium 25 L Laptop Backpack For Office/College/Travel (Black, Yellow)


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expected42 ="Furniture";
        String actual42 = getSatirSutunParametre(4,2);

        Assertions.assertEquals(expected42, actual42);


        //    4.satir , 2.sutundaki datanin "Furniture" oldugunu test edin


    }


    public String getSatirSutunParametre (int satirNo, int sutunNo){

        String istenenHucreData = "";

        //      //tr[   4    ]/td[   2   ]

        String dinamikXpath = "//tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));
        istenenHucreData = istenenHucreElementi.getText();

        return istenenHucreData;
    }


}
