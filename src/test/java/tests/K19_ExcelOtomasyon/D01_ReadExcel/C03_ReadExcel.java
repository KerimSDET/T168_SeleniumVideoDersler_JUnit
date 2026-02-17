package tests.K19_ExcelOtomasyon.D01_ReadExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExcel03() throws IOException {

        // Gerekli ayalamalari yapip, ılkeler excelindeki Sayfa1'e gidin

        String excelFilePath = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(excelFilePath);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet1 = workbook.getSheet("Sayfa1");

        // 1. satirdaki 2. hucreye gidin ve yazdirin

        System.out.println(sheet1.getRow(0).getCell(1));

        // 1. satirdaki 2. hucreyi bir string degiskene atayin
        // ve degerinin "Başkent (İngilizce)" oldugunu test edin
        String row1Cell2 = sheet1.getRow(0).getCell(1).getStringCellValue();
        String expCellValue = "Başkent (İngilizce)";

        Assertions.assertEquals(expCellValue, row1Cell2);

        // 2. satır 4. cell'in afganistan'in baskenti "Kabil" oldugunu test edin
        expCellValue = "Kabil";
        String row2Cell4 = sheet1.getRow(1).getCell(3).getStringCellValue();

        Assertions.assertEquals(expCellValue, row2Cell4);

        // ulke sayisinin 190 oldugunu test edin.

        int actualCountryNo = sheet1.getLastRowNum()+1-1;
        int expectedCountryNo = 192;

        Assertions.assertEquals(expectedCountryNo, actualCountryNo);

        /*
            +1  method bize index getiriyor, satir sayisini bulmak icin +1 ekliyoruz
            -1  basta baslik satiri oldugundan satir sayisindan 1 cikartarak ulke sayisini bulabiliriz

         */

        // Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin

        int fizikiRowNumber = sheet1.getPhysicalNumberOfRows();

        int expectedRowNumber = 193;

        Assertions.assertEquals(expectedRowNumber, fizikiRowNumber);

        // Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        /*
            butun satirlari tek tek kontrol edip
            0.index'deki data Netherlands ise 3.index'deki data'nin Amsterdam oldugunu test edelim
         */

        String expectedBaskent = "Amsterdam";
        for (int i = 0; i <= sheet1.getLastRowNum(); i++) {
            String satirdakiUlkeIsmi =sheet1.getRow(i).getCell(0).getStringCellValue();
            if(satirdakiUlkeIsmi.equalsIgnoreCase("Netherlands")){
                String satirdakTrBaskentIsmi = sheet1.getRow(i).getCell(3).getStringCellValue();

                Assertions.assertEquals(satirdakTrBaskentIsmi, expectedBaskent);
            }
        }

        // Turkce baskent isimlerinde Ankara bulundugunu test edin
        // Turkce baskent isimleri her satirin 3.index'inde
        // bir flag olusturup, her satirdaki baskent ismini kontrol edelim
        // Ankara olan varsa flag'i degistirelim

        boolean isItAnkara = false;

        for (int i = 0; i <= sheet1.getLastRowNum(); i++) {

            String inRowAnkara = sheet1.getRow(i).getCell(3).getStringCellValue();
            if (inRowAnkara.equalsIgnoreCase("Ankara")) {
                isItAnkara = true;
                System.out.println("Ankara "+i+". satırda bulundu");
                break;
            }
        }
        Assertions.assertTrue(isItAnkara);


        // Turkce baskent isminde A olan ulke sayisini bulun

        // Ingilizce ismi B ile baslayan kac ulke bulundugunu test edin



    }




}
