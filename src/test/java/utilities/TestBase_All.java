package utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestBase_All {

    protected static WebDriver driver;

    // TestBase_All içinde setup metodunu şu şekilde revize et:

//    @BeforeAll
//    public static void setup() {
//        ChromeOptions options = new ChromeOptions();
//
//        // Tarayıcıyı gizli modda başlatmak çoğu güvenlik uyarısını (şifre dahil) devre dışı bırakır
//        options.addArguments("--incognito");
//        options.addArguments("--start-maximized");
//        options.addArguments("--disable-notifications");
//
//        // Şifre sızıntı ve yönetim özelliklerini kapatan anahtarlar
//        options.addArguments("--disable-features=PasswordLeakDetection");
//        options.addArguments("--disable-features=SafeBrowsing");
//
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//        prefs.put("safebrowsing.enabled", false);
//        options.setExperimentalOption("prefs", prefs);
//
//        // Otomasyon olduğunu gizleyen ve uyarısını kaldıran kritik ayar
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.setExperimentalOption("useAutomationExtension", false);
//
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @BeforeAll
    public static void setup() {

        ChromeOptions options = new ChromeOptions();

        // Mevcut argümanlar (değiştirilmedi)
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        // 🔑 Zayıf şifre uyarısını kapatmak için yeni/güncellenmiş argümanlar
        options.addArguments("--disable-features=PasswordLeakDetection");  // Parola sızıntısı uyarısını devre dışı bırakır
        options.addArguments("--disable-password-generation");  // Parola oluşturma istemlerini devre dışı bırakır
        options.addArguments("--disable-password-manager-reauthentication");  // Parola yöneticisi yeniden kimlik doğrulamasını devre dışı bırakır
        options.addArguments("--disable-save-password-bubble");  // Parola kaydetme balonunu devre dışı bırakır
        options.addArguments("--disable-web-security");  // Güvenlik kısıtlamalarını gevşetir (test için)
        options.addArguments("--disable-blink-features=AutomationControlled");  // Otomasyon algılamasını devre dışı bırakır

        // 🔑 Chrome password & security popup KAPAT (mevcut prefs'lerin devamı, daha fazla ekleme)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("safebrowsing.enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);  // Bildirimleri tamamen kapat
        options.setExperimentalOption("prefs", prefs);

        // Otomasyon uyarısını kaldırmak için (mevcut)
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}









//bu kod çalıştı
//package utilities;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//public class TestBase_All {
//
//    protected static WebDriver driver;
//
//    @BeforeAll
//    public static void setup() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//
//        // 1. Temel Argümanlar
//        options.addArguments("--remote-allow-origins=*"); // Bağlantı hatalarını önler
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-popup-blocking");
//
//        // 2. 🔑 Şifre ve Güvenlik Uyarılarını Kapatan Argümanlar
//        options.addArguments("--disable-features=PasswordLeakDetection");
//        options.addArguments("--disable-features=SafeBrowsing"); // Bazı sürümlerde bu gereklidir
//
//        // 3. 🔑 Deneysel Tercihler (Prefs)
//        Map<String, Object> prefs = new HashMap<>();
//        // Şifre yöneticisini kapatır
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//        // Güvenli tarama uyarılarını (zayıf şifre dahil) kapatır
//        prefs.put("safebrowsing.enabled", false);
//
//        options.setExperimentalOption("prefs", prefs);
//
//        // 4. "Otomasyon yazılımı tarafından kontrol ediliyor" yazısını kaldırır
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
//    @AfterAll
//    public static void teardown() {
//        if (driver != null) {
//            // driver.quit(); // Test sırasında sonucu görmek istersen geçici olarak kapatabilirsin
//        }
//    }
//}



//package utilities;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.time.Duration;
//
//public class TestBase_All {
//    protected static WebDriver driver;
//
//    @BeforeAll
//    public static void setup() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
//    @AfterAll
//    public static void teardown() {
//        driver.quit();
//    }
//}
