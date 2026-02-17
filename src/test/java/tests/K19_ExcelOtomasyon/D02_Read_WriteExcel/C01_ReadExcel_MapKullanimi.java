package tests.K19_ExcelOtomasyon.D02_Read_WriteExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel_MapKullanimi {


    @Test
    public void test_Kullanimi() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin

        String excelPath = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelPath);
        Workbook wb = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = wb.getSheet("Sayfa1");

    /*
            Eger Ingilizce ulke isimleri ve Turkce baskent isimleri ile
            birden fazla test varsa
            her seferinde for loop yapmak yerine
            data'lara daha rahat ulasabilecegimiz bir Java objesi olan Map'e kaydedebiliriz
            Ingilizce ulke isimleri ==> key
            Turkce baskent isimleri ==> value
         */

        Map<String, String> ulkelerMapi = new TreeMap<>();

        for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
            String satirdakiIngilizceUlkeIsmi = sheet1.getRow(i).getCell(0).getStringCellValue();

            String satirdakiTurkceBaskentIsmi = sheet1.getRow(i).getCell(3).getStringCellValue();

            ulkelerMapi.put(satirdakiIngilizceUlkeIsmi,satirdakiTurkceBaskentIsmi);

            //System.out.println("Satir: " + i);

            //System.out.println(i + " - " + sheet1.getRow(i).getCell(3));


        }

        // Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin

        String expectedBaskent = "Amsterdam";
        String actualBaskent = ulkelerMapi.get("Netherlands");

        Assertions.assertEquals(expectedBaskent,actualBaskent);

        // Turkce baskent isimlerinde Ankara bulundugunu test edin

        Assertions.assertTrue(ulkelerMapi.containsValue("Ankara"));

        // Ulkeler excel'inde ingilizce ismi Ghana olan bir ulke var mi test edin
        Assertions.assertTrue(ulkelerMapi.containsKey("Ghana"));



        fileInputStream.close();
        wb.close();

    }
}

