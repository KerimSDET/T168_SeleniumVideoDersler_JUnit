package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DosyaYolunuDinamikYapma {

    @Test
    void dosyaYolunuTest() {

        //downloads klasöründe deneme.txt dosyasinin var oldugunu test et

        String filePathTest = "C:/Users/KeremTaner/Downloads/deneme.txt";

        System.out.println(System.getProperty("user.home"));


 /*
            /Users/ahmetbulutluoz       /Users/ahmetbulutluoz        /Downloads/deneme.txt
            \\Users\\Cansu              C:\Users\Cansu               \\Downloads\\deneme.txt
            C:\\Users\\Hamza            C:\Users\Hamza               \\Downloads\\deneme.txt
            C:\\Users\\coban            C:\Users\coban               \\Downloads\\deneme.txt
            C:\\Users\\GS               C:\Users\GS                  \\Downloads\\deneme.txt
         */

         /*
            eger dosya yolunu normal olarak yazarsak
            /Users/ahmetbulutluoz/Downloads/deneme.txt
            sadece dosya yolunu olusturan kisinin bilgisayarinda calisir
            baska bilgisayarlarda calismaz

            Java ortak calisabilmemiz icin
            her kisinin bilgisayarinda farkli olan bastaki kismi
            alabilecegimiz bir kod hazirlamistir

            herkeste farkli olan kisim  :  /Users/ahmetbulutluoz
            herkeste ortak olan kisim   :  /Downloads/deneme.txt
         */

        String dinamikDosyaYolunu = System.getProperty("user.home") + "/Downloads/deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolunu)));

        // K15 package'i altinda deneme.txt dosyasinin varligin test et

        String projedenDosyaYoluTesti = "C:/Users/KeremTaner/IdeaProjects/T168_SeleniumVideoDersler_JUnit" +
                "/src/test/java/tests/K15_fileTestleri/deneme.txt";



        /*
             /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team148_JUnit/src/test/java/day09_actionsClass_fileTestleri/deneme.txt

             herkeste farkli olan kisim :    /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team148_JUnit
             herkeste ayni olan kisim   :    /src/test/java/day09_actionsClass_fileTestleri/deneme.txt
         */


        Assertions.assertTrue(Files.exists(Paths.get(projedenDosyaYoluTesti)));



    }
}
