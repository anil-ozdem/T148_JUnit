package day05_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_SetupVeTeardownMethodlari {
    /*
        Java'da tekrar eden kodlari sevmeyiz

        Bir test method'u olusturuldugunda
        basta olusturmamiz gereken driver objesi
        ve sondaki kapatma islemi
        tum method'lar icin lazim

        her test method'unda bunlari tekrar tekrar olusturmak yerine
        method yapip methodCall ile kullanmayi tercih edebiliriz
     */
    WebDriver driver;

    public void setup() {
        // Webdriver olusturup ayarlari yapin
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void teardown() {
        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void testOtomasyonuTest() {
        setup();
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Testotomasyonu testi PASSED");
        } else System.out.println("Testotomasyonu testi FAILED");
        teardown();
    }

    @Test
    public void youtubeOtomasyonuTest() {
        setup();
        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("YouTube testi PASSED");
        } else System.out.println("YouTube testi FAILED");
        teardown();
    }

    @Test
    public void wisequarterTest() {
        setup();
        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        // url'in wisequarter icerdigini test edin
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");
        teardown();
    }
}