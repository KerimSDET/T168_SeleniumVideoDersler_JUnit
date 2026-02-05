package tests.K06_JUnitFrameWork.D03_Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C02_AssertionsMethodlari {
    /*
        assertEquals(a,b) ile assertTrue(a==b)
        eger assertion PASSED olursa yukardaki method'lar arasinda hic bir fark yoktur

        ANCAAAKKK assertion FAILED oldugunda
        assertEquals(a,b) expected (a) ve actual (b) degerlerini karsilastirip
        aradaki farki otomatik olarak bize gosterir

        ama assertTrue(a==b) kullanildiginda
        sadece true bekliyorduk false oldu der

        Bu sebeple MUMKUN OLDUGU surece assertEquals() kullanmayi tercih ederiz
     */


    int a = 10;
    int b = 20;
    int c = 30;
    String url1 = "https://www.testotomasyonu..com";
    String url2 = "https://www.testotomasyonu..com/";

    @Test
    public void test01(){
        //c'nin a ile b nin toplamina esit oldgunu test edin

        Assertions.assertEquals(c,a+b);
    }

    @Test
    public void test02(){
        //c'nin a ile b nin toplamina esit oldgunu test edin

        Assertions.assertTrue(c==a+b);
    }

    @Test
    public void test03(){
        //b'nin a il c toplamina esit oldugunu test edin
        //eger imkan varsa onceligimiz equals kullanmaktir.

        Assertions.assertEquals(b,a+c);
//        org.opentest4j.AssertionFailedError:
//        Expected :20
//        Actual   :40

//        Assertions.assertTrue(b==a+c);

//        org.opentest4j.AssertionFailedError:
//        Expected :true
//        Actual   :false

    }

    @Test
    public void test04(){
        //b'nin a il c toplamina esit olmadigini test edin
        Assertions.assertNotEquals(b,a+c);
    }

    @Test
    public void test05(){
        //url1 ve url2'nin ayni oldugunu test edin
        Assertions.assertEquals(url1,url2);

//        org.opentest4j.AssertionFailedError:
//        Expected :https://www.testotomasyonu..com
//        Actual   :https://www.testotomasyonu..com/
    }

    @Test
    public void test06(){
        //url1 ve url2'nin ayni oldugunu test edin
        Assertions.assertTrue(url1.equals(url2));

//        org.opentest4j.AssertionFailedError:
//        Expected :true
//        Actual   :false
    }

    @Test
    public void test07(){
        //url1 ve url2'nin ayni olmadigini test edin
        Assertions.assertNotEquals(url1,url2);
    }

    @Test
    public void test08(){
        //url1 in "test" kelimesini icerdigini test edin
        Assertions.assertTrue(url1.contains("test"));
    }

    @Test
    public void test09(){
        //url1 in "best" kelimesini icermedigini test edin
        //Assertions.assertTrue(!url1.contains("best"));
        Assertions.assertFalse(url1.contains("best"));
    }











}
