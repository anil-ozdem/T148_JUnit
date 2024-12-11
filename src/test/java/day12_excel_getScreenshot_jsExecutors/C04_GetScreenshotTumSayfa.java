package day12_excel_getScreenshot_jsExecutors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

import java.io.File;

public class C04_GetScreenshotTumSayfa extends TestBaseEach {

    @Test
    public void test01(){

        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = sonucYaziElementi.getText();

        Assertions.assertNotEquals(unExpectedAramaSonucu, actualAramaSonucu);


        // tum sayfanin secreenshot'ini alin

        // 1.adim tss objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/tumSayfaScreenShot.jpeg");



    }
}
