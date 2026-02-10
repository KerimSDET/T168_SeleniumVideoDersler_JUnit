package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class C01_AyniWindowdaGezinme extends TestBase_All {


    @Test
    public void test01(){

        // testotomasyonu sayfasina gidin

        driver.get("https://www.testotomasyonu.com");

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Test Otomasyon Url : "+driver.getCurrentUrl());
        System.out.println("Test Otomasyon Window Handle Degeri : "+driver.getWindowHandle());


        // Electronics linkini tiklayin
        driver.findElement(By.linkText("Electronics")).click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Electronics url : "+driver.getCurrentUrl());
        System.out.println("testotomasyonu window handle degeri : "+driver.getWindowHandle());

        // ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@id=\"shopping-list\"]/div/ul/li[1]/div/a")).click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Electronics url : "+driver.getCurrentUrl());
        System.out.println("testotomasyonu window handle degeri : "+driver.getWindowHandle());


        // account linkine tiklayin
        driver.findElement(By.xpath("//*[@id=\"header_sticky\"]/header/div[2]/div/div[3]/a[1]/span")).click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Account url : "+driver.getCurrentUrl());
        System.out.println("Account window handle degeri : "+driver.getWindowHandle());



    }
}
