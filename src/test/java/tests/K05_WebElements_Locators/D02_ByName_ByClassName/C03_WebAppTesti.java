package tests.K05_WebElements_Locators.D02_ByName_ByClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C03_WebAppTesti {
    public static void main(String[] args) {

        //bir test class oluşturun ilgili ayarları yapın

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // http://zero.webappsecurity.com adresine gidin

        driver.get("http://zero.webappsecurity.com/");


        // "ONLINE BANKING linkine tiklayin

        driver.findElement(By.id("onlineBankingMenu")).click(); //diger click kullanimi

//        WebElement onlineBankingClick = driver.findElement(By.id("onlineBankingMenu"));
//
//        onlineBankingClick.click();

        // REsim altinda 6 islem basligi oldugunu test edin

        List<WebElement> baslikElementleriList = driver.findElements(By.className("headers"));

        int expectedBaslikSayisi = 6;
        int actualBaslikSayisi = baslikElementleriList.size();

        if (actualBaslikSayisi == expectedBaslikSayisi) {
            System.out.println("Baslik Sayisi Testi PASSED");
        } else System.out.println("Baslik Sayisi Testi FAILED");

        // Islem basliklari icinde "Pay Bills" oldugunu test edin.

        /*
        1. yontem : for loop ile her bir WebElementi gozden gecirilip bir flag ile eger istenen metne esit olan
        baslik varsa sonucu true olarak kaydedebilir.
         */

        boolean payBillsVarMi = false;

        for (WebElement eachElement : baslikElementleriList) {
            if (eachElement.getText().equals("Pay Bills")) {
                payBillsVarMi = true;
            }
        }

        if (payBillsVarMi) {
            System.out.println("Pay Bills Testi PASSED");
        } else System.out.println("Pay Bills Testi FAILED");

        //1. yontem sonu

        /*
        2. yontem : Bos bir String list olusturup for loop ile WebElement'ler uzerindeki yazilari alip
        String liste ekleriz. Sonra o String listede aranan basligin olup olmadigini test ederiz
         */

        List<String> baslikYazilariList = new ArrayList<>();

        for (WebElement eachElement : baslikElementleriList) {
            baslikYazilariList.add(eachElement.getText());
            }
        System.out.println("Baslik yazilari : "+baslikYazilariList);

        if (baslikYazilariList.contains("Pay Bills")) {
            System.out.println("Baslik Sayisi Testi PASSED");
        } else System.out.println("Baslik Sayisi Testi FAILED");


        //Sayfayi kapatin

        driver.quit();


    }
}
