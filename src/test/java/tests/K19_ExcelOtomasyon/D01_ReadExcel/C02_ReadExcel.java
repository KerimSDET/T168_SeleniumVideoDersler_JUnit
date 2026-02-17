package tests.K19_ExcelOtomasyon.D01_ReadExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void C02_ReadExcel() throws IOException
    {
        // Gerekli ayarlamaları yapip, ulkeler excel'indeki sayfa2'ye gidin

        String excelFileRoot = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(excelFileRoot);

        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet2 = wb.getSheet("Sayfa2");

        //kullanilan son satirin 20. satir oldugunu test edin

        int usedLastRow = sheet2.getLastRowNum()+1;
        int expectedLastRow = 20;

        Assertions.assertEquals(expectedLastRow, usedLastRow);

        // kullanilan (bos olmayan) satir sayisinin 8 oldugunu tetss edin
        int usedRow = sheet2.getPhysicalNumberOfRows() ;
        int expectedRow = 8;
        Assertions.assertEquals(expectedRow, usedRow);


        //17. satir 5. hucredek bilgi nedir yazdir
        System.out.println("17. satır 5. sütun : " +wb.getSheet("Sayfa2").getRow(16).getCell(4));
        System.out.println(sheet2.getRow(16).getCell(4));

        //satir var ama istenen hucrede bilgi yok



        //5. satir 3. hucredeki bilgiyi yazdirin

    }
}
