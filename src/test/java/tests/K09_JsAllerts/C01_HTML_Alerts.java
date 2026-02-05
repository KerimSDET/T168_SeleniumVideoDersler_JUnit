package tests.K09_JsAllerts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class C01_HTML_Alerts extends TestBase_Each {

    @Test
    public void C01_HTML_Alerts(){
        //google anasayfaya git

        driver.get("https://www.google.com");

        //cookies kabul et
        driver.findElement(By.xpath("//div[text()='Accept all']")).click();

    }
}
