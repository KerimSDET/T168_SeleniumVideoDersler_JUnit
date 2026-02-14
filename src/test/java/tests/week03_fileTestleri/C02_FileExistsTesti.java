package tests.week03_fileTestleri;

import org.junit.jupiter.api.Test;
import utilities.ReuseableMethods;
import utilities.TestBase_Each;

public class C02_FileExistsTesti extends TestBase_Each {

    @Test
    public void C02_FileExistsTesti(){

        driver.get("https://www.facebook.com");

        ReuseableMethods.bekle(20);
    }



}
