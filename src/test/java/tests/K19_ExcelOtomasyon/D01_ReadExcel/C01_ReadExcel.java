package tests.K19_ExcelOtomasyon.D01_ReadExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void C01_ReadExcel() throws IOException {


        /*
                Excel'deki bilgileri kullanabilmek icin
                once excel'deki datalara ulasmamiz lazim
                bilgisayarimizdaki dosyaya selenium WebDriver ile ulasamayacagimiz icin
                Java'dan yardim istemeliyiz
         */

        // 1.adim dosya yolunu alalim

        String excelFileRoot = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";


        // 2.adim Java ile dosyaya erismek icin

        FileInputStream fis = new FileInputStream(excelFileRoot);


        // 3.adim Excel'den alinan bilgileri
        //   kodlarimizin icinde olusturacagimiz bir obje olarak kaydedelim

        Workbook wb = WorkbookFactory.create(fis);

        // Workbook workbook = new Workbook();
        // 'Workbook' is abstract; cannot be instantiated
        // Workbook bir interface oldugundan direkt obje olusturulamaz

        /*
                Artik fiziki excel dosyasindaki tum bilgileri
                kodlarimiz icersinde olusturdugumuz workbook objesine kaydettik.
         */


        // 4.adim excel'in kopyasi olan workbook'da
        //        istedigimiz bilgiye ulasalim
        // Sayfa1'deki 5.satir, 3.hucrede olan bilgiyi yazdirin

        Sheet sheet1 = wb.getSheet("Sayfa1");
        Row row5 = sheet1.getRow(4);
        Cell cell3 = row5.getCell(2);

        System.out.println("5. Satır 3. Hücre : "+cell3);

        // 5.satir 3. cell : Andorra

        /*
                workbook da Java'daki genel kabule uygun olarak
                index kullanir
                index 0'dan basladaigi icin
                5.satir icin index==>4, 3.hucre icin index==>2 secilmelidir
         */


        // her seferinde row ve cell olusturmaya gerek yok
        // Sayfa1'deki 15.satir, 2.hucrede olan bilgiyi yazdirin

        System.out.println(wb.getSheet("Sayfa1").getRow(14).getCell(1));

        // son satir numarasini yazdirin
        System.out.println(wb.getSheet("Sayfa1").getLastRowNum());
        // Java index kullandigi icin bize son satirin index'ini getirir
        System.out.println("Son Satır no: "+(wb.getSheet("Sayfa1").getLastRowNum()+1));

        // Son satir no : 193



        // Kullanilan satir sayisini yazdirin
        System.out.println("Kullanilan Satir Sayisi : "+wb.getSheet("Sayfa1").getPhysicalNumberOfRows());
        //Kullanilan satir sayisi : 191

    }
}
