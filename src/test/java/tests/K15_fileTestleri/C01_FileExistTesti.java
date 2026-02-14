package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExistTesti extends TestBase_Each {

    @Test
    public void FileExistTest(){


        //K15 package altinda deneme.txt var oldugunu test et

        /*
            Selenium'da tum islerimizi WebDriver ile yapiyoruz
            Olusturdugumuz driver objesi bizim adimiza
            istedigimiz tum islemleri yapiyor

            ANNNNCAAAAK WebDriver adindan da anlasilacagi gibi
            Web'de kullanilabilir, bilgisayarimizdaki fiziki dosyalara erisemez

            Bilgisayarimizdaki dosyalara erismek icin Java'dan yardim aliriz
            Java ile dosyaya ulasabilmemiz icin ise
            dosyanin dosyayolunu bilmeliyiz
         */

        String filePathRef = "src/test/java/tests/K15_fileTestleri/deneme.txt";

        System.out.println(Files.exists(Paths.get(filePathRef)));

        // K15 package'i altinda deneme1.txt dosyasinin olmadigini test et

        String filePathRefNot =  "src/test/java/tests/K15_fileTestleri/deneme1.txt";

        System.out.println(Files.exists(Paths.get(filePathRefNot)));

        Assertions.assertTrue(Files.exists(Paths.get(filePathRef)));

        Assertions.assertFalse(Files.exists(Paths.get(filePathRefNot)));


        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String downloadFilePath ="C:/Users/KeremTaner/Downloads/deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(downloadFilePath)));

        System.out.println(Files.exists(Paths.get(downloadFilePath)));


    }
}
