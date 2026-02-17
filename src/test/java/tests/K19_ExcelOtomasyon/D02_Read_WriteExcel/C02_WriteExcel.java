package tests.K19_ExcelOtomasyon.D02_Read_WriteExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeTestExcel() throws IOException {

        //3) Adimlari takip ederek Sayfa1’e kadar gidelim
        String excelPath = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelPath);
        Workbook wb = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = wb.getSheet("Sayfa1");

        //4) 1.satir 5.hucreye yeni bir cell olusturalim
        sheet1.getRow(0).createCell(4);

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sheet1.getRow(0).createCell(4).setCellValue("Nüfus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sheet1.getRow(1).createCell(4).setCellValue(1500000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sheet1.getRow(9).createCell(4).setCellValue(250000);

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sheet1.getRow(14).createCell(4).setCellValue(54000);


        // bos olan ilk satira
        // ingilizce ulke ismi JavaRepublic  ingilizce baskent olarak Selenium yazdiralim

        int firstEmptyRowInd = sheet1.getLastRowNum()+1;

        sheet1.createRow(firstEmptyRowInd);
        sheet1.getRow(firstEmptyRowInd).createCell(0).setCellValue("Java Republic");
        sheet1.getRow(firstEmptyRowInd).createCell(1).setCellValue("Selenium");


        //9) Dosyayi kaydedelim
        /*
            Biz yaptigimiz tum degisikleri
            workbook uzerinde yaptik

            workbook objesi fiziki excel dosyasinda
            FileInputStream ile aldigimiz bilgilerle olusturuldu
            ve excel'in bir kopyasi oldu

            eger workbook uzerinde yaptigimiz degisiklikleri
            excel dosyasina islemek istiyorsak
            kaydetme islemi yapmamiz gerekir.

            ONEMLI NOT :
            workbook'da yaptigimiz degisiklikleri
            excel'e kaydetme islemi yapmadan once
            excel dosyasinin kapali oldugundan emin OLMALISINIZ.
         */

        FileOutputStream fileOutputStream = new FileOutputStream(excelPath);
        wb.write(fileOutputStream);


        //10)Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        wb.close();


    }

}
