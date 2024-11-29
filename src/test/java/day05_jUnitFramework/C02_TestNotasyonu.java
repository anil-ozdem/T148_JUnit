package day05_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TestNotasyonu {
    /*
        @Test notasyonu siradan bir method'u
        tek basina Run edilebilir hale getirir

        @Test notasyonu sayesinde
        her bir testi bagimsiz olarak calistirabilecegimiz gibi
        class isminin yanindaki run tusu ile
        class'daki TUM test method'larini toplu olarak da calistirabiliriz

        JUnit @Test method'larin calisma sirasini
        kendine gore duzenler
        belirlenmis bir siralama duzeni yoktur
        siralamayi ongoremeyiz ve kontrol edemeyiz

        eger sirali calismasini istediginiz
        test method'lari olursa
        isimlerini test01,test02,test03 diye belirlemek gerekir
     */

    @Test
    public void testOtomasyonuTest() {
        // Webdriver olusturup ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Testotomasyonu testi PASSED");
        } else System.out.println("Testotomasyonu testi FAILED");

        driver.quit();
    }

    @Test
    public void youtubeOtomasyonuTest() {
        // Webdriver olusturup ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("YouTube testi PASSED");
        } else System.out.println("YouTube testi FAILED");

        driver.quit();
    }

    @Test
    public void wisequarterTest() {
        // Webdriver olusturup ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        // url'in wisequarter icerdigini test edin
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");

        driver.quit();
    }


}